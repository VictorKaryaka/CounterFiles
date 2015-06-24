package application.input;

import application.counter.ApplicationLogic;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyListener implements NativeKeyListener, Runnable {

	@Override
	public void run() {

		GlobalScreen.getInstance().addNativeKeyListener(this);

		try {
			// register global key listener
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		if (e.getKeyCode() == NativeKeyEvent.VK_ESCAPE) {
			ApplicationLogic.setInterrupt(true);
		}
		if (e.getKeyCode() == NativeKeyEvent.VK_Q) {
			GlobalScreen.unregisterNativeHook();
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

	}
}
