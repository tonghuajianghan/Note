---
title: mockito 基础使用
date:
categories:
- test
tags:
- mockito基础使用
---

mockito 是一个模拟测试框架
一般与junit一起使用
用于模拟复杂的对象 eg: service dao ..



官网 http://site.mockito.org/

Main reference documentation features:

mock()/@Mock: create mock
optionally specify how it should behave via Answer/ReturnValues/MockSettings
when()/given() to specify how a mock should behave
If the provided answers don’t fit your needs, write one yourself extending the Answer interface
spy()/@Spy: partial mocking, real methods are invoked but still can be verified and stubbed
@InjectMocks: automatically inject mocks/spies fields annotated with @Spy or @Mock
verify(): to check methods were called with given arguments
can use flexible argument matching, for example any expression via the any()
or capture what arguments were called using @Captor instead
Try Behavior-Driven development syntax with BDDMockito
Use Mockito on Android, thanks to the team working on dexmaker

Remember

Do not mock types you don’t own
Don’t mock value objects
Don’t mock everything
Show love with your tests!
