/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.airlift.compress.v3.lz4;

import io.airlift.compress.v3.Compressor;
import io.airlift.compress.v3.Decompressor;
import io.airlift.compress.v3.thirdparty.JPountzLz4Compressor;
import io.airlift.compress.v3.thirdparty.JPountzLz4Decompressor;
import net.jpountz.lz4.LZ4Factory;

class TestLz4
        extends AbstractTestLz4
{
    @Override
    protected Compressor getCompressor()
    {
        return new Lz4JavaCompressor();
    }

    @Override
    protected Decompressor getDecompressor()
    {
        return new Lz4JavaDecompressor();
    }

    @Override
    protected Compressor getVerifyCompressor()
    {
        return new JPountzLz4Compressor(LZ4Factory.fastestInstance());
    }

    @Override
    protected Decompressor getVerifyDecompressor()
    {
        return new JPountzLz4Decompressor(LZ4Factory.fastestInstance());
    }
}
