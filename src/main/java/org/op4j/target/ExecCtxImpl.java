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

import java.util.List;

import org.apache.commons.lang.Validate;
import org.op4j.functions.ExecCtx;
import org.op4j.target.ExecutionTargetId;

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


    
    
    public ExecCtxImpl(final ExecutionTargetId targetId) {
        super();
        final List<Integer> ids = targetId.getComponents();
        initialize(
                (ids.size() >= 2? ids.get(1) : null),
                (ids.size() >= 3? ids.get(2) : null),
                (ids.size() >= 4? ids.get(3) : null),
                (ids.size() >= 5? ids.get(4) : null),
                (ids.size() >= 6? ids.get(5) : null));
    }
    
    
    public ExecCtxImpl(final Integer level0Index, final Integer level1Index, final Integer level2Index, final Integer level3Index, final Integer level4Index) {
        super();
        initialize(level0Index, level1Index, level2Index, level3Index, level4Index);
    }

    
    private void initialize(final Integer newLevel0Index, final Integer newLevel1Index, final Integer newLevel2Index, final Integer newLevel3Index, final Integer newLevel4Index) {

        Validate.notNull(newLevel0Index, "Level 0 index cannot be null");
        Validate.isTrue(((newLevel2Index != null && newLevel1Index != null) || newLevel2Index == null),
                "Cannot specify level 2 index if no level 1 index is specified");
        Validate.isTrue(((newLevel3Index != null && newLevel2Index != null) || newLevel3Index == null),
                "Cannot specify level 3 index if no level 2 index is specified");
        Validate.isTrue(((newLevel4Index != null && newLevel3Index != null) || newLevel4Index == null),
                "Cannot specify level 4 index if no level 3 index is specified");
        
        this.level0Index = newLevel0Index;
        this.level1Index = newLevel1Index;
        this.level2Index = newLevel2Index;
        this.level3Index = newLevel3Index;
        this.level4Index = newLevel4Index;
        if (this.level4Index != null) {
            this.level = Integer.valueOf(4);
        } else if (this.level3Index != null) {
            this.level = Integer.valueOf(3);
        } else if (this.level2Index != null) {
            this.level = Integer.valueOf(2);
        } else if (this.level1Index != null) {
            this.level = Integer.valueOf(1);
        } else {
            this.level = Integer.valueOf(0);
        }
        
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
