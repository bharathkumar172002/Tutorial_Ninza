Feature: Validate End To End Shopping Workflow
@Smoke
Scenario Outline: Verify customer can login, search product, add item to cart and checkout successfully

Given login page should be open in default browser

When click on email address field and add valid email "<email>"

And then click on password field and enter valid "<password>"

And now click on login button "<status>"

Then login successfully and redirect to ninja home page

When ninja search input field receives "<product>"

Then ninja custom product list matches criteria

When user clicks on add to cart button for the item

Then product should be added to cart successfully

When user clicks on the black shopping cart button

And clicks on the checkout option

Then user should be redirected to the checkout page

Examples:
| email                    | password      | status  | product     |
| bharathkumar172002@gmail.com   | bharath123   | success | iphone      |
| bharathkumar172002@gmail.com   | bharath123   | success | macbook     |