package data;

//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.PostConstruct;
//
//import org.apache.shiro.session.Session;
//import org.apache.shiro.session.SessionListener;
//import org.apache.shiro.session.SessionListenerAdapter;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.Cache;
//import org.springframework.cache.CacheManager;
//import org.springframework.stereotype.Component;
//
//import com.daou.go.common.util.StringUtil;
//import com.daou.go.core.CacheRegion;
//import com.daou.go.core.ClientType;
//import com.daou.go.core.component.NotiPushManager;
//import com.daou.go.core.domain.User;
//import com.daou.go.core.domain.model.PushMessage;
//import com.daou.go.core.service.CacheGraph;
//import com.daou.go.core.service.CacheMap;
//import com.google.common.collect.Lists;

/**
 * @author louis
 *
 *         회사의 설정(동시 접속 허용 여부, 세션 수명) 을 바탕으로 사용자의 세션을 관리한다.
 */
//@Component
public class AuthenticatedSessionManager {
//
//    protected static final Logger logger = LoggerFactory.getLogger(AuthenticatedSessionManager.class);
//
//    /**
//     * Test 모듈에서 테스트 하면서 sessionManager를 auto inject할 수 없어 에러가 발생한다. TODO 이 부분 정리하자.
//     */
//    @Autowired(required = false)
//    DefaultWebSessionManager sessionManager;
//
//    //    @Autowired
//    //    private EhCacheManagerFactoryBean ehCacheManagerFactoryBean;
//
//    @Autowired
//    private NotiPushManager notiPushManager;
//
//    @Autowired
//    private CacheManager cacheManager;
//
//    /**
//     * 유저의 세션 목록. 세션 목록은 Client Type별로 보관.
//     */
//    CacheMap<Long, Map<ClientType, List<Serializable>>> userSessionMap;
//
//    /**
//     * 세션아이디에 대한 주요 정보.
//     */
//    CacheMap<Serializable, SessionInfo> sessionInfoMap;
//
//    /**
//     * 겸직등의 이유로 함께 로그인/아웃 관리가 되어야 하는 세션 아이디 그래프
//     */
//    CacheGraph<Serializable> sessionIntegrated;
//
//    @PostConstruct
//    public void init() {
//
//        Cache cache = cacheManager.getCache(CacheRegion.GO_SESSION);
//
//        if (cache == null) {
//            logger.error("Can't find authenticated-sessions cache config. it will use hashmap alternativly.");
//            userSessionMap = new CacheMap<Long, Map<ClientType, List<Serializable>>>(null);
//            sessionInfoMap = new CacheMap<Serializable, SessionInfo>(null);
//            sessionIntegrated = new CacheGraph<Serializable>(null);
//        } else {
//            userSessionMap = new CacheMap<Long, Map<ClientType, List<Serializable>>>(cache);
//            sessionInfoMap = new CacheMap<Serializable, SessionInfo>(cache);
//            sessionIntegrated = new CacheGraph<Serializable>(cache);
//        }
//
//    }
//
//    @PostConstruct
//    public void setSessionListener() {
//        if (sessionManager == null) {
//            return;
//        }
//
//        SessionListener listener = new SessionListenerAdapter() {
//            @Override
//            public void onExpiration(Session session) {
//                synchronized (session) {
//                    logger.info("clear expired session : " + session.getId());
//                    doClear(session.getId());
//                }
//            }
//
//            @Override
//            public void onStop(Session session) {
//                synchronized (session) {
//                    logger.info("clear stopped session : " + session.getId());
//                    doClear(session.getId());
//                }
//            }
//        };
//
//        logger.info("add session listener");
//        Collection<SessionListener> listeners = sessionManager.getSessionListeners();
//        listeners.add(listener);
//    }
//
//    private void doClear(Serializable sessionId) {
//        SessionInfo sessionInfo = sessionInfoMap.get(sessionId);
//        if (sessionInfo == null) {
//            return;
//        }
//
//        sessionInfoMap.remove(sessionId);
//        Map<ClientType, List<Serializable>> map = userSessionMap.get(sessionInfo.getUserId());
//
//        if (map == null) {
//            return;
//        }
//
//        List<Serializable> list = map.get(sessionInfo.getClientType());
//        if (list == null) {
//            if (map.isEmpty()) {
//                userSessionMap.remove(sessionInfo.getUserId());
//            }
//
//            return;
//        }
//
//        list.remove(sessionId);
//
//        if (list.isEmpty()) {
//            map.remove(sessionInfo.getClientType());
//
//            if (map.isEmpty()) {
//                userSessionMap.remove(sessionInfo.getUserId());
//            }
//
//        }
//    }
//
//    /**
//     * 새 sessionId를 기록한다.
//     *
//     * <strike>만약 concurrent login이 불허라면 기존 session들(해당 user에 해당 clientType의 Sessions) 은 모두 금지시킨다.</strike>
//     *
//     */
//    public void addSessionId(User user, boolean allowedConcurrentConnection, ClientType agentType,
//            Serializable sessionId, String deviceId) {
//
//        ClientType clientType = agentType;
//        if (clientType == null) {
//            clientType = ClientType.BROWSER;
//        }
//
//        logger.debug("add session: {}", sessionId);
//        String email = user.getEmail();
//        long userId = user.getId();
//
//        List<Serializable> sessions; // userId 유저의 goAgent Client Type으로 발급된 모든
//        // Session 목록.
//        synchronized (this) {
//            Map<ClientType, List<Serializable>> map = userSessionMap.get(userId);
//            if (map == null) {
//                map = new HashMap<ClientType, List<Serializable>>();
//            }
//
//            sessions = map.get(clientType);
//            if (sessions == null) {
//                sessions = new ArrayList<Serializable>();
//                map.put(clientType, sessions);
//            }
//
//            sessions.add(sessionId);
//            userSessionMap.put(userId, map);
//        }
//
//        boolean marked = false;
//        // 모바일 클라이언트에 대해서는 세션 제한 하지 않는다.
//        if (!allowedConcurrentConnection && (clientType.isBrowser() || clientType.isPC())) {
//            marked = markRestricted(sessions);
//        }
//
//        sessionInfoMap.put(sessionId, new SessionInfo(clientType, userId, deviceId));
//
//        if (marked && clientType.isPC()) {
//            // 알림 발송
//            String type = "noti";
//            List<Long> receiveUsers = Lists.newArrayList(userId);
//            String pushDevice = "pc";
//            String xmppMessage = "{\"type\":\"auth\", \"sessionId\":\"" + sessionId + "\"}";
//            Map<String, String> apnsMap = null;
//
//            PushMessage message = PushMessage.getBuilder().type(type).senderId(userId).senderEmail(email)
//                    .receiveUsers(receiveUsers).receiversEmail(email).xmppMessage(xmppMessage).apnsMap(apnsMap)
//                    .pushDevice(pushDevice).build();
//            notiPushManager.sendScheduledQ(message, 2);
//        }
//    }
//
//    /**
//     *
//     * 중복 인증을 허가 한 상태에서 이미 인증 받은 세션 목록이 존재할 수 있으므로 <br/>
//     * 1개 이상의 session이 존재할 수 있다. <br/>
//     * 이 메소드가 호출되었다는 것은 중복 인증을 더이상 허가 하지 않는다는 것이다. <br/>
//     * 이미 인증된 세션들도 모두 제한하게 된다. <br/>
//     *
//     * @param sessions 사용자가 PC와 같은 Device를 이용해 인증 받은 모든 세션 목록
//     * @return mark 여부
//     *
//     */
//    private boolean markRestricted(List<Serializable> sessions) {
//
//        boolean restricted = false;
//
//        for (Serializable sId : sessions) {
//            SessionInfo sessionInfo = sessionInfoMap.get(sId);
//            if (sessionInfo != null) {
//                restricted = true;
//                sessionInfo.restrict();
//                sessionInfoMap.put(sId, sessionInfo);
//            }
//        }
//
//        return restricted;
//    }
//
//    public boolean isRestrictedSession(Serializable sessionId) {
//
//        SessionInfo sessionInfo = sessionInfoMap.get(sessionId);
//        if (sessionInfo == null) {
//            return false;
//        }
//
//        return sessionInfo.isRestricted();
//    }
//
//    public boolean isNotRestrictedSession(Serializable sessionId) {
//
//        return !isRestrictedSession(sessionId);
//    }
//
//    public void removeSessionId(Serializable id) {
//        doClear(id);
//    }
//
//    public Long getSessionUserId(String sessionId) {
//        SessionInfo sessionInfo = sessionInfoMap.get(sessionId);
//        if (sessionInfo == null) {
//            return null;
//        }
//
//        return sessionInfo.getUserId();
//    }
//
//    public String getSessionDeviceId(String sessionId) {
//        SessionInfo sessionInfo = sessionInfoMap.get(sessionId);
//        if (sessionInfo == null) {
//            return null;
//        }
//
//        return sessionInfo.getDeviceId();
//    }
//
//    /**
//     * userId와 deviceId로 sessionId를 구한다
//     *
//     * @param userId
//     * @param deviceId
//     * @return
//     */
//    public List<Serializable> getSessionIdsByUserIdAndDeviceId(Long userId, String deviceId) {
//        Map<ClientType, List<Serializable>> map = userSessionMap.get(userId);
//        List<Serializable> ids = Lists.newArrayList();
//        if (map == null) {
//            return ids;
//        }
//
//        for (ClientType clientType : map.keySet()) {
//            List<Serializable> idsOfClientType = map.get(clientType);
//            if (idsOfClientType == null) {
//                continue;
//            }
//
//            for (Serializable sessionId : idsOfClientType) {
//                SessionInfo sessionInfo = sessionInfoMap.get(sessionId);
//                if (sessionInfo == null) {
//                    continue;
//                }
//
//                if (StringUtil.equals(sessionInfo.getDeviceId(), deviceId)) {
//                    ids.add(sessionId);
//                }
//            }
//        }
//
//        return ids;
//    }
//
//    /**
//     * 일괄 로그아웃 대상이 되는 세션 아이디를 연결한다
//     *
//     * @param from
//     * @param to
//     */
//    public void addSessionLink(Serializable from, Serializable to) {
//        sessionIntegrated.addEdge(from, to);
//    }
//
//    /**
//     * 일괄 로그아웃 대상이 되는 세션 아이디를 모두 제거한다
//     *
//     * @param from
//     */
//    public void removeSessionLink(Serializable from) {
//        List<Serializable> adjacents = sessionIntegrated.getAdjacentVertexes(from);
//        for (Serializable adjacent : adjacents) {
//            sessionIntegrated.removeEdge(from, adjacent);
//        }
//    }
//
//    /**
//     * 일괄 로그아웃 대상이 되는 세션 아이디 모두 반환
//     *
//     * @param from
//     * @return
//     */
//    public List<Serializable> getSessionIdsLinkedFrom(Serializable from) {
//        return sessionIntegrated.getAdjacentVertexes(from);
//    }

}
