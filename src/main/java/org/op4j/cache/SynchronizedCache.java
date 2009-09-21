/*
 * =============================================================================
 * 
 *   Copyright (c) 2008, The OP4J team (http://www.op4j.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.op4j.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.apache.commons.lang.Validate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.op4j.exceptions.CacheException;

/**
 * <p>
 * Base synchronized cache for <tt>*Registry</tt> objects.
 * </p>
 * <p>
 * <b>Do not</b> use this class directly.
 * </p>
 * <p>
 * This class is <b>thread-safe</b>.
 * </p>
 * 
 * @since 1.0
 * 
 * @param <K> key type
 * @param <V> value type
 *  
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class SynchronizedCache<K,V> {

    private final String name;
    private final ConcurrentHashMap<K,Future<V>> cache; 
    private final Log log;
    
    
    /**
     * <p>
     * Create a new synchronized cache.
     * </p>
     * 
     * @param name the cache name (will be used in logging)
     */
    public SynchronizedCache(final String name) {
        super();
        Validate.notNull(name, "Name for cache cannot be null");
        this.name = name;
        this.cache = new ConcurrentHashMap<K,Future<V>>();
        this.log = LogFactory.getLog(this.name);
    }

    
    /**
     * <p>
     * Clear the cache.
     * </p>
     */
    public void clear() {
        this.cache.clear();
    }
    
    
    /**
     * <p>
     * Get the value for a specific key
     * </p>
     * 
     * @param key the key
     * @return the value, or null if not found
     */
    public V get(final K key) {
        while (true) {
            final Future<V> future = this.cache.get(key);
            if (future == null) {
                return null;
            }
            try {
                return future.get();
            } catch (CancellationException e) {
                this.cache.remove(key, future);
            } catch (InterruptedException e) {
                throw new CacheException(this.name, e);
            } catch (ExecutionException e) {
                if (e.getCause() instanceof RuntimeException) {
                    throw (RuntimeException) e.getCause();
                }
                throw new CacheException(this.name, e.getCause());
            }
        }
    }
    

    /**
     * <p>
     * This method executes a <tt>Callable</tt> object, puts its result
     * into the cache and finally returns this result. If an evaluation for
     * the same key is currently ongoing, its result is waited for (instead
     * of computing it again).
     * </p>
     * <p>
     * Once a value is assigned to a key, no substitutions can be done. This
     * means that the same key will not be able to have different values over time.
     * </p>
     * 
     * @param key the key to which the computed value will be assigned
     * @param eval the Callable which will be evaluated to obtain the result
     * @return the result of evaluation
     */
    public V computeAndGet(final K key, final Callable<V> eval) {
        while (true) {
            Future<V> future = this.cache.get(key);
            if (future == null) {
                final FutureTask<V> futureTask = new FutureTask<V>(eval);
                future = this.cache.putIfAbsent(key, futureTask);
                if (future == null) {
                    future = futureTask;
                    futureTask.run();
                    if (this.log.isTraceEnabled()) {
                        this.log.trace(this.name + " (size:" + this.cache.size() + 
                                ") Added value for key: " + key);
                    }
                }
            }
            try {
                return future.get();
            } catch (CancellationException e) {
                this.cache.remove(key, future);
            } catch (InterruptedException e) {
                throw new CacheException(this.name, e);
            } catch (ExecutionException e) {
                if (e.getCause() instanceof RuntimeException) {
                    throw (RuntimeException) e.getCause();
                }
                throw new CacheException(this.name, e.getCause());
            }
        }
    }
    
}
