/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.curator.framework.recipes.cache;

import org.apache.curator.utils.PathUtils;

class GetDataOperation implements Operation
{
    private final PathChildrenCache cache;
    private final String fullPath;

    GetDataOperation(PathChildrenCache cache, String fullPath)
    {
        this.cache = cache;
        this.fullPath = PathUtils.validatePath(fullPath);
    }

    @Override
    public void invoke() throws Exception
    {
        cache.getDataAndStat(fullPath);
    }

    @Override
    public boolean equals(Object o)
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }

        GetDataOperation that = (GetDataOperation)o;

        //noinspection RedundantIfStatement
        if ( !fullPath.equals(that.fullPath) )
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        return fullPath.hashCode();
    }

    @Override
    public String toString()
    {
        return "GetDataOperation{" +
            "fullPath='" + fullPath + '\'' +
            '}';
    }
}
