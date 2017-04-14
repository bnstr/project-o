package steps;

import static utils.PageFactory.initPage;
import static utils.PageFactory.openPage;
import static org.junit.Assert.assertFalse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;

import blinqpages.FurnitureAndDecor;
import blinqpages.HomePage;
import blinqpages.LoginPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchAlertsStepDefinition {
	
	LoginPage loginPage;
	HomePage homePage;
	FurnitureAndDecor furnitureAndDecor;
	
	private static final String TEST_USER = System.getProperty("test.user", "provide valid username");
    private static final String TEST_PASS = System.getProperty("test.pass", "provide valid password");
    
	@Given("^I am a new user on blinq\\.com site$")
	public void i_am_a_new_user_on_blinq_com_site() throws Throwable {
		homePage = openPage(HomePage.class);
	}

	@When("^I perform a search for product \"([^\"]*)\"$")
	public void i_perform_a_search_for_product(String arg1) throws Throwable {
		homePage.search(arg1);
	}

	@Then("^The CREATE ALLERT button is not available$")
	public void the_CREATE_ALLERT_button_is_not_available() throws Throwable {
		assertFalse(homePage.isCreateAlertButtonDisplayed());
	}

	@When("^I login using valid credentials$")
	public void i_login_using_valid_credentials() throws Throwable {
		loginPage = openPage(LoginPage.class);
        loginPage.basicLogin(TEST_USER, TEST_PASS);
        homePage = initPage(HomePage.class);
	}

	@Then("^The CREATE ALLERT button is available$")
	public void the_CREATE_ALLERT_button_is_available() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Clicking it will display the Create New Search Alert modal for \"([^\"]*)\"$")
	public void clicking_it_will_display_the_Create_New_Search_Alert_modal_for(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Create New Search Alert workflow is launched$")
	public void create_New_Search_Alert_workflow_is_launched() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Create New Search Alert modal is displayed with following editable mappings:$")
	public void create_New_Search_Alert_modal_is_displayed_with_following_editable_mappings(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    throw new PendingException();
	}

	@When("^User save the Search Alert$")
	public void user_save_the_Search_Alert() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Search Alert Saved message is displayed$")
	public void search_Alert_Saved_message_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^User can cancel the Create New Search Alert$")
	public void user_can_cancel_the_Create_New_Search_Alert() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Return to previous state$")
	public void return_to_previous_state() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Manage My Search Alerts page contains \"([^\"]*)\" in saved-search-list$")
	public void manage_My_Search_Alerts_page_contains_in_saved_search_list(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^User select the \"([^\"]*)\" frequency$")
	public void user_select_the_frequency(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^\"([^\"]*)\" Search Alert is updated$")
	public void search_Alert_is_updated(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^User rename \"([^\"]*)\" into \"([^\"]*)\"$")
	public void user_rename_into(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I click the delete icon for \"([^\"]*)\" Search Alert$")
	public void i_click_the_delete_icon_for_Search_Alert(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^\"([^\"]*)\" Search Alert is marked as deleted$")
	public void search_Alert_is_marked_as_deleted(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^UNDO DELETE button is available$")
	public void undo_DELETE_button_is_available() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^User logout$")
	public void user_logout() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^User login$")
	public void user_login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Manage My Search Alerts page does not contains \"([^\"]*)\" in saved-search-list$")
	public void manage_My_Search_Alerts_page_does_not_contains_in_saved_search_list(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^mockserver is setup for e(\\d+)e alert validation test$")
	public void mockserver_is_setup_for_e_e_alert_validation_test(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^New Search Alert modal is created with following editable mappings:$")
	public void new_Search_Alert_modal_is_created_with_following_editable_mappings(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    throw new PendingException();
	}

	@When("^Insert test product for e(\\d+)e alert validation test$")
	public void insert_test_product_for_e_e_alert_validation_test(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Validate mockserver received content email for e(\\d+)e alert validation test$")
	public void validate_mockserver_received_content_email_for_e_e_alert_validation_test(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
