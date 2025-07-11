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
package com.reandroid.unity.metadata.index;

import com.reandroid.arsc.base.Creator;
import com.reandroid.unity.metadata.data.MethodDefinitionData;
import com.reandroid.unity.metadata.section.MetadataSectionType;
import com.reandroid.unity.metadata.spec.MethodSpec;
import com.reandroid.unity.metadata.spec.Spec;

public class MethodDefinitionIndex extends DefinitionIndex<MethodDefinitionData> {

    public MethodDefinitionIndex() {
        super(MetadataSectionType.METHODS);
    }

    public String getName() {
        MethodDefinitionData data = getData();
        if (data != null) {
            return data.getName();
        }
        return null;
    }

    @Override
    public MethodSpec getSpec() {
        return (MethodSpec) super.getSpec();
    }

    @Override
    public void onIndexLinked(Object linker) {

    }

    @Override
    public Object getJson() {
        Spec spec = getSpec();
        if (spec != null) {
            return spec.json();
        }
        return super.getJson();
    }

    @Override
    public String toString() {
        return get() + "{" + getName() + "}";
    }

    public static Creator<MethodDefinitionIndex> CREATOR = MethodDefinitionIndex::new;
}
