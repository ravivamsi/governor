/**
 * 
 */
package com.cgovern.governor.commons;

import java.util.List;

import com.cgovern.governor.models.Index;

/**
 * @author vamsiravi
 *
 */
public class Sequence {

	public static Long getLastUsed(List<Index> indexList) {

		Long lastUsedSequence = Long.MIN_VALUE;

		for (Index currentIndex : indexList) {

			if (lastUsedSequence < currentIndex.getSequence()) {
				lastUsedSequence = currentIndex.getSequence();
			}

		}

		return lastUsedSequence;
	}

	public static Long generateNextSequence(Long lastUsed) {
		return lastUsed + 1;
	}

}
