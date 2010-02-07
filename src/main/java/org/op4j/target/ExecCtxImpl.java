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

package org.op4j.target;

import org.op4j.functions.ExecCtx;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ExecCtxImpl implements ExecCtx {

    
    private Integer level0Index;
    private Integer level1Index;
    private Integer level2Index;
    private Integer level3Index;
    private Integer level4Index;
    private Integer level;


    
    
    public ExecCtxImpl(final int[] indices) {
        super();
        initialize(
                Integer.valueOf(indices.length - 1),
                (indices.length >= 1? Integer.valueOf(indices[0]) : null),
                (indices.length >= 2? Integer.valueOf(indices[1]) : null),
                (indices.length >= 3? Integer.valueOf(indices[2]) : null),
                (indices.length >= 4? Integer.valueOf(indices[3]) : null),
                (indices.length >= 5? Integer.valueOf(indices[4]) : null));
    }

    
    private void initialize(final Integer newLevel, final Integer newLevel0Index, final Integer newLevel1Index, final Integer newLevel2Index, final Integer newLevel3Index, final Integer newLevel4Index) {

        this.level = newLevel;
        this.level0Index = newLevel0Index;
        this.level1Index = newLevel1Index;
        this.level2Index = newLevel2Index;
        this.level3Index = newLevel3Index;
        this.level4Index = newLevel4Index;
        
    }
    

    public Integer getLevel0Index() {
        return this.level0Index;
    }


    public Integer getLevel1Index() {
        return this.level1Index;
    }


    public Integer getLevel2Index() {
        return this.level2Index;
    }


    public Integer getLevel3Index() {
        return this.level3Index;
    }

    
    public Integer getLevel4Index() {
        return this.level4Index;
    }

    public Integer getCurrentIndex() {
        switch (this.level.intValue()) {
            case 0: return this.level0Index;
            case 1: return this.level1Index;
            case 2: return this.level2Index;
            case 3: return this.level3Index;
            case 4: return this.level4Index;
        }
        // Will never happen
        return null;
    }


    public Integer getIterationLevel() {
        return this.level;
    }

    
    
    
}
