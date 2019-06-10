/*
 * Copyright (c) 2019, Red Hat, Inc. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
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
package org.openjdk.backports.jira;

public class RelNotesIssue implements Comparable<RelNotesIssue> {
    final String output;
    final String priority;
    final int fixVer;
    final boolean hasNotes;

    public RelNotesIssue(String output, String priority, int fixVer, boolean hasNotes) {
        this.output = output;
        this.priority = priority;
        this.fixVer = fixVer;
        this.hasNotes = hasNotes;
    }

    public String getOutput() {
        return output;
    }

    @Override
    public int compareTo(RelNotesIssue other) {
        int v1 = Boolean.compare(other.hasNotes, hasNotes);
        if (v1 != 0) {
            return v1;
        }

        int v2 = Integer.compare(other.fixVer, fixVer);
        if (v2 != 0) {
            return v2;
        }

        int v3 = priority.compareTo(other.priority);
        if (v3 != 0) {
            return v3;
        }

        return this.output.compareTo(other.output);
    }
}
