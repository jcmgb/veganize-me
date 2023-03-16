// @ts-check
const { test, expect } = require('@playwright/test');

const home = 'http://veganizeme-angular-app.s3-website-us-east-1.amazonaws.com/';

test.beforeEach(async ({ page }) => {
  await page.goto(home);
});

test('has title', async ({ page }) => {
  // Expect a title "to contain" a substring.
  await expect(page).toHaveTitle(/Veganize Me/);
});

test('list all recipes link', async ({ page }) => {
  // Click the list all recipes link.
  await page.getByRole('link', { name: 'List All Recipes' }).click();

  // Expects the URL to contain recipes.
  await expect(page).toHaveURL(/.*recipes/);
});
