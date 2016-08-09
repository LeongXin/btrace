/*
 * Copyright (c) 2008, 2015, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the Classpath exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.sun.btrace.runtime;

import org.junit.Test;

/**
 *
 * @author Jaroslav Bachorik
 */
public class BTRACE87Test extends InstrumentorTestBase {
    @Test
    public void bytecodeValidation() throws Exception {
        originalBC = loadTargetClass("issues/BTRACE87");
        transform("issues/BTRACE87");
        checkTransformation("ASTORE 2\nALOAD 0\nLDC \"containerMethod\"\n" +
                            "ICONST_0\nANEWARRAY java/lang/Object\n" +
                            "INVOKESTATIC resources/issues/BTRACE87.$btrace$traces$issues$BTRACE87$o (Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)V\n" +
                            "ALOAD 2\nASTORE 3\nASTORE 4\nALOAD 0\nLDC \"containerMethod\"\n" +
                            "ICONST_1\nANEWARRAY java/lang/Object\n" +
                            "DUP\nICONST_0\nALOAD 3\nAASTORE\n" +
                            "INVOKESTATIC resources/issues/BTRACE87.$btrace$traces$issues$BTRACE87$o (Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)V");
    }
}
