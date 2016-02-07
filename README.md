# JMusic

JMusic is a library developed in Java (and NetBeans) that allows management to create a mp3 music player.

I created the library for my projects in the area of Algorithms and Programming III at School of Engineering at the Andrés Bello Catholic University (UCAB) in Caracas, Venezuela.

After years working with the library, I decided to release it as an open source project.

The library is based on JLayer -> http://www.javazoom.net/javalayer/javalayer.html.

The goals of this code are:

* Abstracting mp3 player implementation in Java
* Allow people who don't know the implementation of a mp3 player create one in Java very easily
* Allow programming teachers create more interesting and complex projects without the need for implementing a mp3 music player

## Adding JMusic to your project

You need to follow these steps:

* Add the JMusic library JAR file to you project
* Create a JMusicPlayerList list with the mp3 info for each song
* Use the MusicPlayerControl.initMusicPlayer method with mp3 music files path and JLabel that contains the song information
* Use the MusicPlayerControl.loadSongs method with the JMusicPlayerList list
* That's it!

## Optional steps:

Use the following methods (at MusicPlayerControl class) in order to control your music player:

* playAllSongs
* playSong
* pauseSong
* nextSong
* prevSong
* repeatSong
* repeatSongsFromTheBeginning
* resumeSong
* stopSong

## Internal JMusic mp3 music player

If you want it, you can use the internal JMusic mp3 music player. You just need to follow the next steps:

* Create a JMusicPlayerList list with the mp3 info for each song
* Use the JMusicPlayer.main method with mp3 music files path and the JMusicPlayerList list
* Done! :3

## Javadoc

If you need any help with the library methods you can use the javadoc documentation (it's include in the project)

## Support && contact

### Email

You can contact me using my email: ricardo.casanova@outlook.com

### Twitter

Follow me [@rcasanovan](http://twitter.com/rcasanovan) on twitter.
