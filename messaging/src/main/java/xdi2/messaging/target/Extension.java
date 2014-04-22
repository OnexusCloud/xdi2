package xdi2.messaging.target;

import java.util.Comparator;

public interface Extension <CONTAINER> {

	/*
	 * Init and shutdown
	 */

	public void init(CONTAINER container) throws Exception;
	public void shutdown(CONTAINER container) throws Exception;

	public int getInitPriority();
	public int getShutdownPriority();

	/*
	 * Enabled?
	 */

	public boolean skip();
	public boolean getEnabled();
	public void setEnabled(boolean enabled);
	public boolean getDisabledForOperation();
	public void setDisabledForOperation(boolean disabledForOperation);
	public boolean getDisabledForMessage();
	public void setDisabledForMessage(boolean disabledForMessage);
	public boolean getDisabledForMessageEnvelope();
	public void setDisabledForMessageEnvelope(boolean disabledForMessageEnvelope);

	/*
	 * Class for sorting by init or shutdown priority
	 */

	public static class InitPriorityComparator implements Comparator<Extension<?>> {

		@Override
		public int compare(Extension<?> extension1, Extension<?> extension2) {

			return Integer.valueOf(extension1.getInitPriority()).compareTo(Integer.valueOf(extension2.getInitPriority()));
		}
	}

	public static class ShutdownPriorityComparator implements Comparator<Extension<?>> {

		@Override
		public int compare(Extension<?> extension1, Extension<?> extension2) {

			return Integer.valueOf(extension1.getShutdownPriority()).compareTo(Integer.valueOf(extension2.getShutdownPriority()));
		}
	}
}
