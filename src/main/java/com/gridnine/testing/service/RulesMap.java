package com.gridnine.testing.service;

import com.gridnine.testing.rule.implement.ArrivalEarlierThanDeparture;
import com.gridnine.testing.rule.implement.DepartureBeforeCurrentTime;
import com.gridnine.testing.rule.implement.TotalTimeBetweenSegmentsIsMore2Hours;
import com.gridnine.testing.rule.Rule;
import com.gridnine.testing.enumeration.RulesEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RulesMap {
    static Map<RulesEnum, Rule> ruleMap;

    static {
        ruleMap = new HashMap<>();
        ruleMap.put(RulesEnum.DEPARTURE_BEFORE_CURRENT_TIME, new DepartureBeforeCurrentTime());
        ruleMap.put(RulesEnum.ARRIVAL_EARLIER_THAN_DEPARTURE, new ArrivalEarlierThanDeparture());
        ruleMap.put(RulesEnum.TOTAL_TIME_BETWEEN_SEGMENTS_IS_MORE_2_HOURS, new TotalTimeBetweenSegmentsIsMore2Hours());
    }

    static public List<Rule> getRules(RulesEnum... rulesEnums) {
        List<Rule> ruleList = new ArrayList<Rule>();
        for (RulesEnum rulesEnum : rulesEnums) {
            ruleList.add(ruleMap.get(rulesEnum));
        }
        return ruleList;
    }
}
