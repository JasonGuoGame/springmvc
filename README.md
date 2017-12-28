# springmvc
1,use spring mvc to create a webapp
#
2,use spring security to implement login and logout.
Security: Authentication Manager, AuthentionProvider, UserDetailService.
#
3,use spring oauth2 to generate token.
token will be store to REDIS.
#
4,use spring aop and aspectj to implement AOP
Use the simplest thing that can work. Spring AOP is simpler than using full AspectJ as there is no requirement to introduce the AspectJ compiler / weaver into your development and build processes. If you only need to advise the execution of operations on Spring beans, then Spring AOP is the right choice. If you need to advise objects not managed by the Spring container (such as domain objects typically), then you will need to use AspectJ. You will also need to use AspectJ if you wish to advise join points other than simple method executions (for example, field get or set join points, and so on).
#
5,use hibernate of spring jpa to implement repository and DAO pattern.
different of DAO and Repository pattern

