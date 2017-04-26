## Design "method"
- agile principle: no big design upfront
 - why?
 - when to spend time on design?
 - how
 
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
- why and how ?
- MVC
- Front Controller
- Command pattern

## UML
