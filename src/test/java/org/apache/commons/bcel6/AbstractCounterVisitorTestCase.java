/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package org.apache.commons.bcel6;

import org.apache.commons.bcel6.classfile.DescendingVisitor;
import org.apache.commons.bcel6.classfile.JavaClass;
import org.apache.commons.bcel6.visitors.CounterVisitor;

public abstract class AbstractCounterVisitorTestCase extends AbstractTestCase
{
    protected abstract JavaClass getTestClass() throws ClassNotFoundException;

    private CounterVisitor visitor = null;

    @Override
    public void setUp() throws ClassNotFoundException
    {
        visitor = new CounterVisitor();
        new DescendingVisitor(getTestClass(), getVisitor()).visit();
    }

    public CounterVisitor getVisitor()
    {
        if (visitor == null) {
            visitor = new CounterVisitor();
        }
        return visitor;
    }

    public void setVisitor(CounterVisitor visitor)
    {
        this.visitor = visitor;
    }
}