package programming.exercise;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class AccessControlCoordinatorTest {
    @InjectMocks
    AccessControlCoordinator accessControlCoordinator;

    @Mock(name="accessControlDecisionMaker1")
    AccessControlDecisionMaker accessControlDecisionMaker1;

    @Mock(name="accessControlDecisionMaker2")
    AccessControlDecisionMaker accessControlDecisionMaker2;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFirstOneReturnsTrue(){
        when(accessControlDecisionMaker1.performAccessCheck("someBook")).thenReturn(true);
        assertThat(accessControlCoordinator.performAccessCheckForBook("someBook"),is(true));
    }

    @Test
    public void testSecondOneReturnsTrue(){
        when(accessControlDecisionMaker2.performAccessCheck("someBook")).thenReturn(true);
        assertThat(accessControlCoordinator.performAccessCheckForBook("someBook"),is(true));
    }

    @Test
    public void testBothReturnTrue(){
        when(accessControlDecisionMaker1.performAccessCheck("someBook")).thenReturn(true);
        when(accessControlDecisionMaker2.performAccessCheck("someBook")).thenReturn(true);
        assertThat(accessControlCoordinator.performAccessCheckForBook("someBook"),is(true));
    }

    @Test
    public void testBothReturnFalse(){
        when(accessControlDecisionMaker1.performAccessCheck("someBook")).thenReturn(false);
        when(accessControlDecisionMaker2.performAccessCheck("someBook")).thenReturn(false);
        assertThat(accessControlCoordinator.performAccessCheckForBook("someBook"),is(false));
    }

    @Test(expected=NullPointerException.class)
    public void testNullIdentifierShouldThrowException(){
        accessControlCoordinator.performAccessCheckForBook(null);
    }
}
