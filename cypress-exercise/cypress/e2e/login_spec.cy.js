describe("template spec", () => {
  it("Nhiệm vụ 1: Truy cập trang học liệu Cypress", () => {
    cy.visit("https://example.cypress.io");
  });

  it("Nhiệm vụ 2: Đăng nhập thành công vào SauceDemo với tài khoản valid", () => {
    cy.visit("https://www.saucedemo.com");
    cy.get("#user-name").type("standard_user");
    cy.get("#password").type("secret_sauce");
    cy.get("#login-button").click();

    // Kiểm tra kết quả
    cy.url().should("include", "/inventory.html");
  });

  it("Should show error message with invalid credentials", () => {
    cy.visit("https://www.saucedemo.com");
    cy.get("#user-name").type("invalid_user");
    cy.get("#password").type("wrong_password");
    cy.get("#login-button").click();
    cy.get(".error-message-container").should(
      "contain",
      "Username and password do not match",
    );
  });
});
