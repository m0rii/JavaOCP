package wbs.pattern.factory;

public class Factory {

}
//factory ist kein exakt beschriebenes pattern.
//es ist kein pattern der GoF.
//grundidee: clients bekommen referenzen auf objekte,
//ohne einen konstruktor seiner klasse aufzurufen.

//was verbindet, was unterscheidet die folgenden factories?
//welche design-ziele werden jeweils verfolgt?

//Integer -> Integer
//Paths -> Path
//FileSystems -> FileSystem
//Executors -> ExecutorService
//TimeZone -> TimeZone
//Persistence -> EntityManagerFactory -> EntitManager
//Driver -> Connection
//DriverManager -> Connection
//DataSource -> Connection  -> vorteil transaction implementation
//ResourceBundle -> ResourceBundle
//DAOFactory -> IBuchDAO
//SaxParserFactory -> SaxParserFactory
//RowSetProvider -> RowSetFactory -> RowSet
// ...
// ->  caching von objekten(Immutable , equals())   zB Integer.valueOf()
// ->    portabilitaet  zB Path  windows linux und a....
// ->     portabilitaet
// ->       loose coupling
// ->       poling
// ->       dekoration
// ->   
// ->   
