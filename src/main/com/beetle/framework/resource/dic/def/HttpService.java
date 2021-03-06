package com.beetle.framework.resource.dic.def;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/*
 * 定义rpc服务直接暴露为web服务（依赖于servlet容器）
 */
@Retention(RUNTIME)
@Target({ ElementType.METHOD })
public @interface HttpService {// authentication
	/**
	 * 服务是否要验证
	 *
	 */
	public static enum Authentication {
		/**
		 * YES
		 */
		YES(0),
		/**
		 * NO
		 */
		NO(1);

		private final int value;

		private Authentication(int value) {
			this.value = value;
		}

		public int value() {
			return this.value;
		}
	}

	/**
	 * 返回的数据格式
	 *
	 */
	public static enum ReturnDataFormat {
		/**
		 * JSON
		 */
		JSON(0),
		/**
		 * XML
		 */
		XML(1);

		private final int value;

		private ReturnDataFormat(int value) {
			this.value = value;
		}

		public int value() {
			return this.value;
		}
	}

	public abstract ReturnDataFormat returnDataFormat() default ReturnDataFormat.JSON;

	public abstract Authentication authentication() default Authentication.YES;
}
