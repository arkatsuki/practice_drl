package com.drl.config;

import java.util.Map;
import java.util.Map.Entry;

import org.kie.api.definition.rule.Rule;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <p>
 *  A listener that will track all rule firings in a session.
 * </p>
 * 
 */
public class TrackingAgendaEventListener extends DefaultAgendaEventListener {

	private static Logger log = LoggerFactory.getLogger(TrackingAgendaEventListener.class);
	
	/**
	 * 规则匹配之后，日志记录rule信息
	 */
	@Override
	public void afterMatchFired(AfterMatchFiredEvent event) {
		// 匹配的规则
		Rule rule = event.getMatch().getRule();

		String ruleName = rule.getName();
		Map<String, Object> ruleMetaDataMap = rule.getMetaData();

		StringBuilder sb = new StringBuilder("Rule fired: " + ruleName);

		if (ruleMetaDataMap.size() > 0) {
			sb.append("\n  With [" + ruleMetaDataMap.size() + "] meta-data:");
			for(Entry<String, Object>  entry : ruleMetaDataMap.entrySet()){
				sb.append("\n    key=" + entry.getKey() + ", value=" + entry.getValue());
			}
		}

		log.info(sb.toString());
	}

}
