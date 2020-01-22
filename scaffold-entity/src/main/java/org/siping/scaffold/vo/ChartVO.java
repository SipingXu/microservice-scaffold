package org.siping.scaffold.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Siping
 * @date 2018/5/3 10:43
 * @description
 */
@Data
public class ChartVO implements Serializable {

	private String name;

	private String value;

	public ChartVO() {
	}

	public ChartVO(String name, String value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public String toString() {
		return "ChartVO{" +
				"name='" + name + '\'' +
				", value=" + value +
				'}';
	}
}
