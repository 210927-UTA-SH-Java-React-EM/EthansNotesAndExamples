# Jest/Enzyme

Jest is an open source testing framework designed by facebook for use with React, but it is also functional with other JS frameworks

Jest is popular because:
- it is lightweight compared to other testing frameworks
- has robust test writing capababilities
- mocking capabilities (create fake dependent classes to mock API data/user input)
- snapshots to see each render of a component to ensure you are not rendering something errornous and then immediately rendering
- capable of testing the DOM easily

Jest is the default React testing framework, theres nothing to install

Uses natural langage syntax as much as possible:

```js
test('the sum of values should be', () => {
    expect(sum(values)).toBe(sum_of_values);
});
```

```js
it('renders succesfully', () => {
    //testing logic
})
```

We can use other frameworks to help automate and run the Jest tests for you, including:
- Enzyme
- Selenium
- React Testing Library

Enzyme is another open source testing utility for React which makes it easier to test your React component output

Enzymes API is meant to be intuitive and flexible by mimicking jQueries API for DOM manipulation and traversal

# npm run build

To build and package you React project you would use the command `npm run build`

This command will bundle all of your files together and output a single folder with the final application that you can host