package org.template.base.test.util;
import java.lang.reflect.Field;

/**
 * Utility class that allows you to assign or extract a private or public field
 * value within an object.
 */
public final class ReflectionTestUtil {

	public static final String EXCEPTION_MESSAGE = "No such field: ";

	private ReflectionTestUtil() {
		throw new IllegalStateException("Utility class");
	}

	private static Field getField(Class<?> aClass, String fieldName) throws ReflectiveOperationException {
		if (aClass == null) {
			throw new ReflectiveOperationException(EXCEPTION_MESSAGE + fieldName);
		}

		try {
			return aClass.getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			return getField(aClass.getSuperclass(), fieldName);
		}
	}

	/**
	 * Extracts the value of a private or public field, without the need to invoke a
	 * get method.
	 *
	 * @param affectedObject Object
	 * @param fieldName      Field name
	 * @return Current value
	 * @throws ReflectiveOperationException If the field does not exist
	 */
	public static Object getFieldValue(Object affectedObject, String fieldName) throws ReflectiveOperationException {
		if (affectedObject == null || fieldName == null) {
			throw new ReflectiveOperationException(EXCEPTION_MESSAGE + fieldName);
		}

		Field affectedField = getField(affectedObject.getClass(), fieldName);
		affectedField.setAccessible(true);

		try {
			return affectedField.get(affectedObject);
		} catch (IllegalAccessException e) {
			throw new ReflectiveOperationException(e);
		}
	}

	/**
	 * Sets a new value to the field.
	 *
	 * @param affectedObject Object
	 * @param fieldName      Field name
	 * @param newValue       Value to set
	 * @throws ReflectiveOperationException If the field does not exist
	 */
	public static void setFieldValue(Object affectedObject, String fieldName, Object newValue) throws ReflectiveOperationException {
		if (affectedObject == null || fieldName == null) {
			throw new ReflectiveOperationException(EXCEPTION_MESSAGE + fieldName);
		}

		Field affectedField = getField(affectedObject.getClass(), fieldName);
		affectedField.setAccessible(true);

		try {
			affectedField.set(affectedObject, newValue);
		} catch (IllegalAccessException e) {
			throw new ReflectiveOperationException(e);
		}
	}

	/**
	 * Sets a new value to a static field
	 *
	 * @param clazz     Affected class
	 * @param fieldName Field name
	 * @param newValue  Value to set
	 * @throws ReflectiveOperationException If the field does not exist
	 */
	public static void setStaticFieldValue(Class<?> clazz, String fieldName, Object newValue) throws ReflectiveOperationException {
		if (fieldName == null) {
			throw new ReflectiveOperationException(EXCEPTION_MESSAGE + fieldName);
		}

		Field affectedField = getField(clazz, fieldName);
		affectedField.setAccessible(true);

		try {
			affectedField.set(null, newValue);
		} catch (IllegalAccessException e) {
			throw new ReflectiveOperationException(e);
		}
	}

	/**
	 * Extracts the value of a private or public static field.
	 *
	 * @param clazz     Affected class
	 * @param fieldName Field name
	 * @return Current value
	 * @throws ReflectiveOperationException If the field does not exist
	 */
	public static Object getStaticFieldValue(Class<?> clazz, String fieldName) throws ReflectiveOperationException {
		if (fieldName == null) {
			throw new ReflectiveOperationException(EXCEPTION_MESSAGE + fieldName);
		}

		Field affectedField = getField(clazz, fieldName);
		affectedField.setAccessible(true);

		try {
			return affectedField.get(null);
		} catch (IllegalAccessException e) {
			throw new ReflectiveOperationException(e);
		}
	}

}

