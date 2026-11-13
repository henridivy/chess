# ♕ BYU CS 240 Chess

This project demonstrates mastery of proper software design, client/server architecture, networking using HTTP and WebSocket, database persistence, unit testing, serialization, and security.

## 10k Architecture Overview

The application implements a multiplayer chess server and a command line chess client.

[![Sequence Diagram](10k-architecture.png)](https://sequencediagram.org/index.html#initialData=C4S2BsFMAIGEAtIGckCh0AcCGAnUBjEbAO2DnBElIEZVs8RCSzYKrgAmO3AorU6AGVIOAG4jUAEyzAsAIyxIYAERnzFkdKgrFIuaKlaUa0ALQA+ISPE4AXNABWAexDFoAcywBbTcLEizS1VZBSVbbVc9HGgnADNYiN19QzZSDkCrfztHFzdPH1Q-Gwzg9TDEqJj4iuSjdmoMopF7LywAaxgvJ3FC6wCLaFLQyHCdSriEseSm6NMBurT7AFcMaWAYOSdcSRTjTka+7NaO6C6emZK1YdHI-Qma6N6ss3nU4Gpl1ZkNrZwdhfeByy9hwyBA7mIT2KAyGGhuSWi9wuc0sAI49nyMG6ElQQA)

Sequence Diagram URL: https://sequencediagram.org/index.html#initialData=IYYwLg9gTgBAwgGwJYFMB2YBQAHYUxIhK4YwDKKUAbpTngUSWDABLBoAmCtu+hx7ZhWqEUdPo0EwAIsDDAAgiBAoAzqswc5wAEbBVKGBx2ZM6MFACeq3ETQBzGAAYAdAE5M9qBACu2AMQALADMABwATG4gMP7I9gAWYDoIPoYASij2SKoWckgQaJiIqKQAtAB85JQ0UABcMADaAAoA8mQAKgC6MAD0PgZQADpoAN4ARP2UaMAAtihjtWMwYwA0y7jqAO7QHAtLq8soM8BICHvLAL6YOlAowADWMACy2apIDjDvAGbQxwQFMGw3ioSA4KA4mGENRgpQq8GQ5nqgScTmG4zm6mA9nm9TGAFEoN46jA9BwYLcAI6pHJjK7oCFQygwypsTjcYnjSZQaZzc4HMYbVTbKC7RbLNZjI4nM5i2mYVlcJlwqGieq3LI5SgACgyGrAlAyVLUYAAlJDqqJmTJtEoVOp6tiwABVAZark8lBm2TyW1qVRW4y1ABi7zJLso3uAJMsMHdszENzuj3DsE2SDA8VjAw9MGACFuwA4MZQAA9smANJHfeoYcqLSp6inI+aRCpa5VGcSFPm7kX2g90HiSypsP9Cp32-CSmAkU5gmixhjVFiccsCUT6nmC0WYPJ7ug5fTMFXlH7JyqGzA0D4EAgWyC23CT3bVLUQAX9Sm3QNI16baeazhQMFA4MMf20e9LSff8XzfD8UAUHwMy1YAkPiX9jxgs8gJ0WoQLJRCM2bC9DFhFl2EVYldXLA01BvLAFXZc9qkoepOWzeMllxcVllQjN2ggfc0C45ZLnvJU4WKREYHCFEFzjXkYG4-k+PiAShJE-Y6U4UwvF8AJoHYbEYiDOA8WkOAFBgAAZCAskKKSyg7FjiWaNoul6Ax1HyNB5I43lZQlQVhVFLTrgLR4Xm8j5vl+PIASBCAQTBBkXMnRyZxgZFUVGRc-RXBY10JaB6lJckUCNGltNS6glXItlWJgdipk4wL1n0IUdj5K5GLqqpWxQeoEDs94tVs+wAEk0ENalTUgx9KmfP0HRQZ1XQUz1MJ9AD-Rw4NQxgJttGjLMWrmcKk0OgYYDTDNTu5eMjAgNQ0AAcmYUtyy2xQduYgb6mvW95tIutauJJb1CHEcx3E2AyKnaTkQARjRZYlwK3F1xK2NpjQ6AkAAL3BQ8dIh3bQYfQarojCCSKtMm4LufVCPiFC0IwsmA1w-CYBZ4j6xB+rKPqcapoyVR6PlCimPhzs2Imfz5iU0SVLQ9SD2VsKJ3hjL6lknLmoexTlIlVT1eEzWxKPTxvD8fwvBQdAYjiRIHad8bfCwDKrTlxppDxay8XaPFuh6Ly3gKYYzcE9BYatXqOTGaONOUnrpb6kihrsz2xrslokJm40zTp6DttgmBhvsfO1u1ZP0D-MvsMqQMQ04Xn2eOnQYzrwpEwedv+JjtAnpe96YE+nJvurcnnP+q8bzvEuKcasmoZQUcfLjnWEQwWcUdGNH8uxQr8WK4kfFxjN8aJ3Zqqn37ZYF+o+dpgX6aw+1bhmJKELQtmiO0A3H6L4ub1AyN-GgA90KvwGpOBOIs84FzoggBi6c4bL0TujY+uJK7YjJJ7GAEsdpfAXpYOU2tJI70yvrBcWDVxjFweCGABCiEvhIbeMhd8bb6X8LcMk-hsDvEeNZcsMAADi8YNDewwfUBoYig6h3sPGKOash5byFuyeoUsGpw1npTIa5YJEYi1MXN+pdgHLRgI6F+8h-5qSHkA6eoCYCtwIh3eQJ0e4XX7izc2I9VBvQ+mWSenNH5z0BovMxMjrSN0hsOdeMMKGVF1llJw+8RiH0xNgoqG4caqWvsTO+oSKaqigfzWB5jp4GJyEYtQdiOYf12s3XCYjVq5lvFYyR98QFhP0eIyRIjJ592TNdeI+grwQE6RiUwS8NGNQAHIQFqaocWksE5-RqGxTJy5sljDQJMpRGJcxUGlLobgcpvYAB5YT9U2TJOSB88pZPofsqZahjmnOSPMO+szWBoPqMswZYBVkoO0ZRDZjUMljEOWoBYwwGhNWhfGCa0hCpI3CMEQIEpNjxHTCgFMHo+QSmSKAe4BLWr7AlDC+Z8ZZQXBgJ0YYVwkkI13vcg2ywYWqDhWgBF4wYUorRRirFywcV4vJQFSlywSUgDJYrIlnL4w0rmHShlTKzA6W4XbDgAB2NwTgUBOBiHiYIcAzIADZ4DwX6XMGARQqE+xcrI1oHRFHKMvvYoSC5qWtRVsytKcJ4GIp9QFP1YKZZ6NKe+JmKBalanmSgTYtTC45FMRUxajSVpgBscAOx5tHEP2aftNuObPGqKEt4x4vih7+MCePYJWBimRsvBE4GELwaNLXhvAoW9KHTj3qjJ5Oz6FY3Ph6gpt8NUQibbc0pOa22VJ2ozOQsb4xahDZtUJRarUxtzG3QsZI0CJreSitt1yYkWPtFeRNtSF2Bv+TABNSb4wgtQTo9t8sBWovqOizF-qwbpSoXrB5-LkXfpgL+wIXC9J20sCgW8EBNjOyQAkMAcGENIYAFIQHeDaww-gZX3HtdOR1YNnVOg8j0GFKjB5etytgBAwA4NQDgBAYaUAT4AHUWATWDj0AAQtZBQcAADSqxhiKrmIKn9wr-3QnvTo+WDGmOUFY+xrjPG+OCeE2JlYEmkVSfA5BtO76SmXgAFY4bQHG7D7xk0VVmmmym79YmvisatL8PcC09KLa46mUBIxlto7HGdmd-PlOc4u2Clm7Nrq-d5puRhcK81Am83ckyuSvX9Fys9pQL1VOvc+86vyg1PvsxLUF6zemQqHRjSThgYtHt2DAOTElklAfZbQo+9CYUwEa8TFrU7dK2wCF4JjyHUNjZjIgO4sBgDYAY4QeKw9iPmFI3cho-tA7B1DsYdRfzFN2qq82qmIBuB4C1DNvAKa5olwza5+oZ3ZsmO6YlwMYJuD6iMNoPQBhXuASLaoeIiHvvyF+2IULT955AxKw+p713kFvvBdVzB3WT4fdWoYVhfp2FLFa+g9r-bOvD3RGj3EGOvvY-ULjwbR4gA

## Modules

The application has three modules.

- **Client**: The command line program used to play a game of chess over the network.
- **Server**: The command line program that listens for network requests from the client and manages users and games.
- **Shared**: Code that is used by both the client and the server. This includes the rules of chess and tracking the state of a game.

## Starter Code

As you create your chess application you will move through specific phases of development. This starts with implementing the moves of chess and finishes with sending game moves over the network between your client and server. You will start each phase by copying course provided [starter-code](starter-code/) for that phase into the source code of the project. Do not copy a phases' starter code before you are ready to begin work on that phase.

## IntelliJ Support

Open the project directory in IntelliJ in order to develop, run, and debug your code using an IDE.

## Maven Support

You can use the following commands to build, test, package, and run your code.

| Command                    | Description                                     |
| -------------------------- | ----------------------------------------------- |
| `mvn compile`              | Builds the code                                 |
| `mvn package`              | Run the tests and build an Uber jar file        |
| `mvn package -DskipTests`  | Build an Uber jar file                          |
| `mvn install`              | Installs the packages into the local repository |
| `mvn test`                 | Run all the tests                               |
| `mvn -pl shared test`      | Run all the shared tests                        |
| `mvn -pl client exec:java` | Build and run the client `Main`                 |
| `mvn -pl server exec:java` | Build and run the server `Main`                 |

These commands are configured by the `pom.xml` (Project Object Model) files. There is a POM file in the root of the project, and one in each of the modules. The root POM defines any global dependencies and references the module POM files.

## Running the program using Java

Once you have compiled your project into an uber jar, you can execute it with the following command.

```sh
java -jar client/target/client-jar-with-dependencies.jar

♕ 240 Chess Client: chess.ChessPiece@7852e922
```
