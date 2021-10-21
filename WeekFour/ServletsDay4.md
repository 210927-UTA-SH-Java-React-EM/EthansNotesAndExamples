# NodeJS

NodeJS is an open-source, cross platform, run-time environment for Javascript built on Chromes V8 engine
- It is NOT a programming language
- It is a run-time environment that allows you to run Javascript code outside of the browser

npm or Node Package Manager is a package manager for the Javascript Programming language. It is the default package manager for the Javascript environment

npm consists of three components:
- the website: discovers packages, setup profiles, and manage access to packages
- CLI runs from the terminal and allows us to interact with npm
- the registry is a public database of Javascript packages

We use Node and npm as tools for building React Applications

# package.json

When you create a Javascript project with node, it automatically creates a package.json in the root directory of the project

The package.json holds information or metadata about the project, including:
- description
- version
- license information
- author
- entry point
- dependencies
- scripts

There are two types of dependencies in the package.json
- dependencies: are essential to running the application
- devDependencies: are dependencies that are only being used during development of the application

To create a node project use `npm init`

## Other useful npm scripts/arguments

- `npm init` will create an new node project
- `npm install packagename` will install any packages listed/described
- `npm i packagename`
- `npn install -g packagename` will install a package globally
- `npm install -D packagename` will install a package as a dev dependency
