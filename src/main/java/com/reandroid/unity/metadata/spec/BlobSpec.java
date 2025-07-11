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
package com.reandroid.unity.metadata.spec;

import com.reandroid.arsc.base.Block;
import com.reandroid.json.JSONArray;

public class BlobSpec implements ValueSpec {

    private final byte[] value;

    private BlobSpec(byte[] value) {
        this.value = value;
    }

    @Override
    public byte[] getValue() {
        return value;
    }

    @Override
    public String descriptor() {
        return json().toString(0);
    }

    @Override
    public JSONArray json() {
        byte[] bytes = this.getValue();
        int length = bytes.length;
        JSONArray jsonArray = new JSONArray(length);
        for (int i = 0; i < length; i++) {
            jsonArray.put(bytes[i] & 0xff);
        }
        return jsonArray;
    }
    public static BlobSpec of(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        return new BlobSpec(bytes.clone());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BlobSpec spec = (BlobSpec) obj;
        return Block.areEqual(getValue(), spec.getValue());
    }

    @Override
    public int hashCode() {
        return Block.hashCodeOf(getValue());
    }

    @Override
    public String toString() {
        return descriptor();
    }
}
