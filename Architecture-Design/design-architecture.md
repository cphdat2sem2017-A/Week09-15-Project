## Agile Development 
### Principles
Agile software development is based on the [agile manifesto](http://agilemanifesto.org/) and a number of [underlying principles](http://agilemanifesto.org/principles.html), hereunder:
- Simplicity--the art of maximizing the amount of work not done--is essential
- The best architectures, requirements, and designs emerge from self-organizing teams

So agile teams do not follow detailed enterprise design guidelines to make "a big design up front" in the beginning of a project.The simplicity principle means, that the team will do what is needed and asked for, but no more. 

### Why?
[Simplicity](http://www.extremeprogramming.org/values.html) will maximize the value created for the investment made to date. This means max. business value with the smallest programming effort. Developers will take small simple steps to their goal and mitigate failures as they happen and developers grow wiser on the future IT system.

There is no reason to spend a lot of time on building a detailed design as you might not really know what you are doing early on in a project. Non-agile developers (in waterfall projects) will tell you to reduce risk by modeling everything in detail, but if you step back and think about it for a minute, this actually increases your risk. Does it really make sense to do a lot of detailed modeling when you don't really know what you're doing? Think about modeling a full database in the very first Scrum sprint. Probably not something that you really are bapable of doing at that point in time.

Most often you do not know whether a design solution is going to work, until you have proved it with code. Therefore the best design evolves over time, instead of being defined up front.

### How?
How does good design then come up? There are a number of ways and techniques. Some of them are described below.

#### Sprint Zero 
In Scrum there is often a Sprint Zero which is used to create the basic skeleton of the code (called software architecture) and the infrastructure for the project (e.g setting up github and servers) so that the next sprints can add business value in an efficient way. You may need to do some experimenting in sprint Zero to get wiser (they are often called spikes in agile). Minimal design up front is done in Sprint Zero so that emergent design is possible in future sprints. This includes putting together a flexible enough arhitecture so that refactoring is easy.

For minimal design up front, the team picks a few critical stories and develops them to completion. Since these are the first few stories, delivering them includes putting the skeleton in place, but even Sprint Zero delivers value even though the velocity of Sprint Zero may be very low compared to that of other sprints.

#### Test-driven development
If the team is test-driven, developers will start coding the unit tests first. Creating a unit test helps a developer to  consider what needs to be done. Requirements are clarified by writing the test. You will also get immediate feedback while you work which is really good as it is often not otherwise clear when a developer has finished all the necessary functionality. 

After writing the first unit test, you create the simplest code that will make that test pass. Then you create a second test. Now you add to the code you just created to make this new test pass, but no more! Not until you have yet a third test. And so on.

At some point you might feel that this simplest possible code needs some attention. When we remove redundancy, eliminate unused functionality, and improve obsolete designs we are refactoring. Refactoring throughout the entire project life cycle saves time and increases quality. Refactor mercilessly to keep the design simple as you go and to avoid needless clutter and complexity. Keep your code clean and concise so it is easier to understand, modify, and extend. Make sure everything is expressed once and only once. In the end it takes less time to produce a system that is well groomed.

#### Pair programming
[Pair programming](http://www.extremeprogramming.org/rules/pair.html) increases software quality without impacting time to deliver. It is counter intuitive, but 2 people working at a single computer will add as much functionality as two working separately except that it will be much higher in quality. With increased quality comes big savings later in the project.

![Cost curve](../img/comparingTechniques.jpg)

#### Getting help from developers and tools
In code reviews you have developers outside the team spent time looking at YOUR code. This activity can help identify code that can do with some improvement.

Static test tools (like JaCoCoverage and Source Code Metrics in Netbeans) can also give you hints about your code. Features of static analysis tools are:

- To calculate metrics such as cyclomatic complexity or nesting levels (which can help to identify where refactoring is needed and/or where more testing may be needed due to increased risk)
- To enforce coding standards
- To analyze structures and dependencies

Both code reviews and static test tools are called static test techniques because the code is not executed. Instead we/tools are looking at the code.
 
#### Good design
Good sóftware design has the following qualities:
- maintainable
- reusable
- testable
- robust 

A Java program should follow the OO principles: abstraction, encapsultation, and modularity.

[SOLID principles](https://en.wikipedia.org/wiki/SOLID_(object-oriented_design)) are good guidelines to improve maintainablity and make the software easier to extend over time.

[Design patterns](https://en.wikipedia.org/wiki/Software_design_pattern) can also be applied to the code in order to improve the code design. A design pattern is a general reusable solution to a commonly occurring problem within a given context. 
There will be shown some concrete examples of design patterns  in the section sections below: System Design and Object Design.

## System Design 
### Layers
Decomposing a system into layers is the most commonly used software architectural style. Most often a three layered architecture is used, where each layer can only us the adjacent lower level. 
We typically have:
- UI layer which represents the presentation logic, i.e. handling the interaction between the user and the software. The primary responsibilties of this layer are to display information to the user and to interpret commands from the user into actions upon the domain model layer.
- Data source layer which contains the logic to communicate with other systems that carry out tasks on behalf of the application. These can be databases, mail servers, other applications etc.
- Domain model layer which contains the business logic. This is the work that the application needs to do for the domain that you are working with. This involves for example calculations based on inputs and stored data, validation of the data from the presentation layer, and finding out which data source logic to dispatch, depending on commands received from the presentation.

<picture 3 layer architecture>

- why?
- how?

## Object Design
Architecture is more abstract than design and has focus on decomposing a system into smaller modules (subsystems or layers) whereas object design is more about how a specify module/subsystem/layer is implemented.
- why and how ?
- MVC
- Front Controller
- Command pattern

## UML
