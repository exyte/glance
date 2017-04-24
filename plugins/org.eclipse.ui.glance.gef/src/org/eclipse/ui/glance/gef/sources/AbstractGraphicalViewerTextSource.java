/*******************************************************************************
 * Copyright (c) 2017 Exyte
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Igor Zapletnev - initial API and implementation
 ******************************************************************************/
package org.eclipse.ui.glance.gef.sources;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.ui.glance.sources.ITextSource;
import org.eclipse.ui.glance.sources.SourceSelection;

public abstract class AbstractGraphicalViewerTextSource implements ITextSource {

    public void index(final IProgressMonitor monitor) {
        monitor.done();
    }

    public boolean isIndexRequired() {
        return false;
    }

    public SourceSelection getSelection() {
        return null;
    }

    boolean disposed = false;

    public boolean isDisposed() {
        return disposed;
    }

    public void dispose() {
        disposed = true;
    }
}
