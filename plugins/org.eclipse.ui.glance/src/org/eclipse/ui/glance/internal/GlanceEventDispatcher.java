/*******************************************************************************
 * Copyright (c) 2017 Exyte
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Yuri Strot - initial API and implementation
 *******************************************************************************/
package org.eclipse.ui.glance.internal;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.bindings.Binding;
import org.eclipse.jface.bindings.BindingManager;
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.keys.BindingService;
import org.eclipse.ui.internal.keys.WorkbenchKeyboard;
import org.eclipse.ui.keys.IBindingService;

import org.eclipse.ui.glance.internal.search.SearchManager;

@SuppressWarnings("restriction")
public class GlanceEventDispatcher {

	public static final String GLANCE_CTX = "org.eclipse.ui.glance.context";

	public static final String NEXT_COMMAND = "org.eclipse.ui.glance.nextResult";
	public static final String PREV_COMMAND = "org.eclipse.ui.glance.prevResult";
	public static final String FOCUS_COMMAND = "org.eclipse.ui.glance.commands.focus";
	public static final String CLOSE_COMMAND = "org.eclipse.ui.glance.commands.close";
	public static final String CLEAR_COMMAND = "org.eclipse.ui.glance.commands.clearHistory";

	public static GlanceEventDispatcher INSTANCE = new GlanceEventDispatcher();

	private final BindingManager bindingManager;

	private GlanceEventDispatcher() {
		bindingManager = ((BindingService) PlatformUI.getWorkbench()
				.getService(IBindingService.class)).getBindingManager();
	}

	public void dispatchKeyPressed(Event event) {
		@SuppressWarnings("unchecked")
		List<Object> potentialKeyStrokes = WorkbenchKeyboard
				.generatePossibleKeyStrokes(event);
		if (potentialKeyStrokes.isEmpty()) {
			return;
		}

		String commandID = getBindCommand(KeySequence
				.getInstance((KeyStroke) potentialKeyStrokes.get(0)));
		if (commandID == null) {
			return;
		} else if (FOCUS_COMMAND.equals(commandID)) {
			SearchManager.getIntance().sourceFocus();
		} else if (NEXT_COMMAND.equals(commandID)) {
			SearchManager.getIntance().findNext();
		} else if (PREV_COMMAND.equals(commandID)) {
			SearchManager.getIntance().findPrevious();
		} else if (CLOSE_COMMAND.equals(commandID)) {
			SearchManager.getIntance().close();
		} else if (CLEAR_COMMAND.equals(commandID)) {
			SearchManager.getIntance().clearHistory();
		}
	}

	public String getBindCommand(KeySequence keySequence) {
		Map<?, ?> map = bindingManager.getActiveBindingsDisregardingContext();
		List<?> bindings = (List<?>) map.get(keySequence);
		if (bindings != null) {
			for (Object obj : bindings) {
				Binding binding = (Binding) obj;
				if (GLANCE_CTX.equals(binding.getContextId())) {
					return binding.getParameterizedCommand().getId();
				}
			}
		}
		return null;
	}

}
