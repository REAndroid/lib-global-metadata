/*
 *  Copyright (C) 2022 github.com/REAndroid
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.reandroid.unity.metadata.section;

import com.reandroid.unity.metadata.header.MetadataSectionHeader;
import com.reandroid.unity.metadata.data.StringLiteral;

public class SectionStringLiteral extends MetadataSection<StringLiteral> {

    public SectionStringLiteral(MetadataSectionHeader sectionHeader) {
        super(sectionHeader);
    }

    @Override
    public void onPreRemove(StringLiteral item) {
        super.onPreRemove(item);
        item.onRemovedInternal();
    }

    @Override
    int sizeOfEntry() {
        return 8;
    }
    @Override
    public void link() {
    }

}
