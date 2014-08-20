Overview
========
On updating Spring Boot from 1.1.4 to 1.1.5 a simple web application started generating detached entity exceptions. A quick check of loaded dependencies showed that Spring Data has been updated and a further check of the change log shows a couple of issues relating to optimistic locking, version fields and JPA issues that have been fixed.

Well I am using a version field and it starts out as Null following recommendation to not set in the specification.

I have managed to produce a very simple test case now where I get detached entity exceptions if the version field starts as null or zero. If I create an entity with version 1 however then I do not get these exceptions.

The first two tests fail with detached entity exception. The last two tests pass as expected.

Now change Spring Boot version to 1.1.4 and rerun, all tests pass.

Is this expected behaviour or are my expectations wrong?