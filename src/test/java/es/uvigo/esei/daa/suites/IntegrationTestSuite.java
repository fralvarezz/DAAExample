package es.uvigo.esei.daa.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.uvigo.esei.daa.rest.PeopleResourceTest;
import es.uvigo.esei.daa.rest.UsersResourceTest;
import es.uvigo.esei.daa.rest.PetsResourceTest;


@SuiteClasses({ 
	PeopleResourceTest.class,
	UsersResourceTest.class,
	PetsResourceTest.class
})
@RunWith(Suite.class)
public class IntegrationTestSuite {
}
