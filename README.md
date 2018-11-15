# Javacord-FyreBot

A multipurpose bot being used as a learning experience. Bot functions are tailored to my specific needs/wants.

## Note
At the moment this bot can be used as a template. In the future, additional features that will only work on my server may be added (This note will be updated).

## Built With

* [Java](https://www.java.com/) - Programming language
* [Javacord](https://javacord.org/) - Java library
* [Gradle](https://gradle.org/) - Build automation system

## Running the bot for testing

To run the bot right from Gradle (just for testing, not for production) you can do `gradlew run --args your-bot-token-here`.
You can view the login process by looking at the 
[Main.java](https://github.com/Pavillin/Javacord-FyreBot/blob/master/src/main/java/com/deadfyre/fyrebot/Main.java)
class.

## Building the bot for production

To get a distributable package you run `gradlew distZip`. The created zip is located at `build/distributions/fyrebot-0.1.0.zip` and contains all necessary things to run the bot, except the token.
Take a look at the [build.gradle](https://github.com/Pavillin/Javacord-FyreBot/blob/master/build.gradle) file.

## Running the bot for production

After you built the distributable package as described in the previous section, you can copy over the zip file to where you want to run your bot. There you unzip it where ever you like and run one of the included start scripts.

```shell
unzip fyrebot-0.1.0.zip
cd fyrebot-0.1.0
bin/fyrebot your-bot-token-here
```

The log file will be created in a `log` directory where you execute the last command.
