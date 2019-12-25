/**
 * 
 */
package com.cgovern.governor.commons;

import java.util.List;

import com.cgovern.governor.models.Dependency;
import com.cgovern.governor.models.Dependency.StatusEnum;
import com.cgovern.governor.models.Status.OverallstatusEnum;

/**
 * @author vamsiravi
 *
 */
public class Evaluator {

	public static OverallstatusEnum overallStatus(List<Dependency> dependencies) {

		OverallstatusEnum overallstatus = OverallstatusEnum.UNKNOWN;

		if (!dependencies.isEmpty()) {

			for (Dependency dependency : dependencies) {
				if (dependency.getStatus().equals(StatusEnum.DOWN)) {

					overallstatus = OverallstatusEnum.DOWN;

				} else if (dependency.getStatus().equals(StatusEnum.UP)) {
					overallstatus = OverallstatusEnum.UP;
				} else {
					overallstatus = OverallstatusEnum.UNKNOWN;
				}
			}

		}

		return overallstatus;

	}

}
