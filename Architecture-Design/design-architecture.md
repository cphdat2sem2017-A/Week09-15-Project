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
In code reviews you have developers outside the team spend time walking through YOUR code and give you feedback on its quality. This activity can help identify code that can do with some improvement.

Static test tools (like JaCoCoverage and Source Code Metrics in Netbeans) can also give you hints about your code. Features of static analysis tools are:

- To calculate metrics such as cyclomatic complexity or nesting levels (which can help to identify where refactoring is needed and/or where more testing may be needed due to increased risk)
- To enforce coding standards
- To analyze structures and dependencies

Both code reviews and static test tools are called static test techniques because the code is not executed. The code is being investigated without having the application up running.
 
#### Good design
Good software design has the following qualities:
- maintainable
- reusable
- testable
- robust 

For a starter, a Java program should follow the OO principles: 
- abstraction. This basically means writing classes that only contain relevant data and methods. For instance a Customer class with name and address, but without irrelevant information such as puls rate or shoe size.
- encapsulation. This basically means restricting direct access to an object's attributes by using the private modifier. The internal details of a class must be hidden from outside. The class has methods that provide user interfaces by which the services provided by the class may be used. 
- modularity. This is the process of decomposing a problem (program) into a set of modules so as to reduce the overall complexity of the problem

[SOLID principles](https://en.wikipedia.org/wiki/SOLID_(object-oriented_design)) are five principles for better maintainability and make  the software easier to extend over time. The SOLID guidelines can be applied while working on software to remove code smells. So it is perfectly fine to ship some simple code in one sprint and refactor it in the next spring with the help of the SOLID principles.

So the learning lesson is to start with the agile simplicity principle and the OO principles. When the code starts to overwhelm you, then you look into the SOLID guidelines for help. 

[Design patterns](https://en.wikipedia.org/wiki/Software_design_pattern) can also be applied to improve the code design. A design pattern is a general reusable solution to a commonly occurring problem within a given context. 
There will be given some concrete examples of design patterns  in the sections below: System Design and Object Design.

## System Design 
There is often some confusion about the differences between the concepts architecture and design. There is not a clear definition of the term software architecture, but there is a general agreement on software achitecture as being more abstract and high-level than software design. So architecture is the overall design of the system. Developers divide the system into manageable pieces to deal with complexity. Layering is one of the most common techniques that is used to break apart an application into managable pieces.

### Layers
Layers is a commonly used software architectural style. Most often a three layered architecture is used, where each layer can only us the adjacent lower level. 

Breaking down a system into layers has some benefits:

- You can understand a single layer as a coherent whole without knowing much about the other layers.
- You can replace layers with alternative implementations of the same basic services
- You minimimze the dependencies between layers. If we change the database server, the UI is not affected by the change


We typically have:
- Presentation layer which represents the presentation logic, i.e. handling the interaction between the user and the software. The primary responsibilties of this layer are to display information to the user and to interpret commands from the user into actions upon the domain model layer.
- Data access layer which contains the logic to communicate with other systems.These can be databases, mail servers, other applications etc.
- Business logic layer which contains the domain model and the business logic. This is the work that the application needs to do for the domain that you are working with. This involves for example calculations based on inputs and stored data, validation of the data from the presentation layer, and finding out which data source logic to dispatch, depending on commands received from the presentation.

![3 layer architecture](../img/3layers.jpg)

### Facade
Encapsulation of a layer is best done by introducing a Facade in the layer. Facade is a design pattern that is used to provide a unified interface to the layer which will makes the layer easier to use for its clients. All clients can only communicate with the layer through its Facade. 

A Facade pattern is implemented as a class (or to increase the flexibility, an interface will be even better so you can [stub](https://martinfowler.com/eaaCatalog/serviceStub.html) it). The Facade class will typically end up with a a lot of methods and will in itself have low cohesion (which is usually a bad thing). But since it's job is to hide the internal structure and implementation details of the layer to its clients, it is acceptable with low cohesion in the Facade. It will on the other hand make the coupling of the system low, which is a good thing.

Layers without a Facade


![layers1](../img/layers.PNG)




Layers with a Facade


![layers1](../img/layers2.PNG)

### MVC
A Model-View-Controller architecture splits the user interaction into three distinct roles. We separate the presentation logic in the presentation layer from the domain model in the business logic layer. A controller in the presentation layer (a Servlet) will act as a middle-man between the two layers. It is the controller that makes sure that information is retrieved from the business logic layer (which again will delegate the task of retrieving data from the database to the data access layer) and the controller will hand over the data to the jsp pages for presentation on the screen. 


![layers1](../img/MVC.PNG)

Doing this is important for several reasons.

- Working on a view concerns dealing with the mechanisms of UI and to lay out a good user interface. Working on the model deals with other tasks such as business policies and transactions. You will use different libraries and possible different programming models.
 
- Separating the view allows you to develop multiple interfaces (web, app, swing etc.) based on the same model code and thus making reuse of business logic more convenient.

- Nonvisual objects are easier to test than visual ones. You can unit test the domain objects more easily when domain logic resides in its own non-UI objects.

## Object Design
Architecture is more abstract than design and has focus on decomposing a system into smaller modules (subsystems or layers) whereas object design is more about how a specify module/subsystem/layer is implemented.

Object design includes
- reuse, where off-the-shelf components and design patterns can be identified to makew use of existing solutions
- service specification, during which we precisely describe each class interface
- object model restructuring, during which we restructure the object model design to improve its understandibility snd extensibility

We will look into a number of patterns that each is a solution to certain type of problem.

### Front Controller
A pattern used in presentation layer to handle all requests for a Website in a centralized manner.

### Command 
A pattern used in the presentation layer to handle the incoming actions from the jsp pages together with the Front Controller servlet in a very flexible and generic way. Basically the imlementation of this pattern will remove the if-if else statements from the servlet. A command object will act as a controller object that initiates an action, for instance login, create customer, or delete order.

### Controller
A pattern used in the business logic layer to coordinate and control the application flow for an action such as login, create customer, or delete order.


