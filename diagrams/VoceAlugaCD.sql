CREATE TABLE AbstractQueue (
);


CREATE TABLE AbstractStringBuilder (
);


CREATE TABLE Appendable (
);


CREATE TABLE ArrayDeque (
);


CREATE TABLE ArrayList (
);


CREATE TABLE Arrays (
);


CREATE TABLE BitSet (
);


CREATE TABLE BlockingDeque (
);


CREATE TABLE BlockingQueue (
);


CREATE TABLE Boolean (
);


CREATE TABLE Byte (
);


CREATE TABLE Calendar (
);


CREATE TABLE Character (
);


CREATE TABLE CharSequence (
);


CREATE TABLE Class (
);


CREATE TABLE Cliente (
 nome VARCHAR(10),
 idade VARCHAR(10),
 listaNegra BIT(10)
);


CREATE TABLE Cloneable (
);


CREATE TABLE Collection (
);


CREATE TABLE Collections (
);


CREATE TABLE Comparable (
);


CREATE TABLE Comparator (
);


CREATE TABLE ConcurrentSkipListMap (
);


CREATE TABLE ConcurrentSkipListSet (
);


CREATE TABLE Currency (
);


CREATE TABLE Date (
);


CREATE TABLE Deque (
);


CREATE TABLE Dictionary (
);


CREATE TABLE Double (
);


CREATE TABLE Enum (
);


CREATE TABLE Enumeration (
);


CREATE TABLE EnumMap (
);


CREATE TABLE EnumSet (
);


CREATE TABLE EventListener (
);


CREATE TABLE EventListenerProxy (
);


CREATE TABLE EventObject (
);


CREATE TABLE Exception (
);


CREATE TABLE Float (
);


CREATE TABLE Formattable (
);


CREATE TABLE FormattableFlags (
);


CREATE TABLE Formatter (
);


CREATE TABLE HashMap (
);


CREATE TABLE HashSet (
);


CREATE TABLE Hashtable (
);


CREATE TABLE IdentityHashMap (
);


CREATE TABLE Integer (
);


CREATE TABLE Iterable (
);


CREATE TABLE Iterator (
);


CREATE TABLE LinkedHashMap (
);


CREATE TABLE LinkedHashSet (
);


CREATE TABLE LinkedList (
);


CREATE TABLE List (
);


CREATE TABLE ListIterator (
);


CREATE TABLE LocalDate (
);


CREATE TABLE Long (
);


CREATE TABLE Map (
);


CREATE TABLE Math (
);


CREATE TABLE NavigableSet (
);


CREATE TABLE Number (
);


CREATE TABLE Object (
);


CREATE TABLE Observable (
);


CREATE TABLE Observer (
);


CREATE TABLE PriorityQueue (
);


CREATE TABLE ProcessBuilder (
);


CREATE TABLE Queue (
);


CREATE TABLE RandomAccess (
);


CREATE TABLE Readable (
);


CREATE TABLE Reserva (
 dataFim DATE,
 dataInicio DATE
);


CREATE TABLE Runnable (
);


CREATE TABLE Scanner (
);


CREATE TABLE ServiceLoader (
);


CREATE TABLE Set (
);


CREATE TABLE Short (
);


CREATE TABLE SortedMap (
);


CREATE TABLE SortedSet (
);


CREATE TABLE Stack (
);


CREATE TABLE String (
);


CREATE TABLE StringBuffer (
);


CREATE TABLE StringBuilder (
);


CREATE TABLE StringTokenizer (
);


CREATE TABLE System (
);


CREATE TABLE Thread (
);


CREATE TABLE Throwable (
);


CREATE TABLE TreeMap (
);


CREATE TABLE TreeSet (
);


CREATE TABLE UUID (
);


CREATE TABLE Vector (
);


CREATE TABLE Void (
);


CREATE TABLE WeakHashMap (
);


CREATE TABLE Carro (
 grupo VARCHAR(10),
 modelo VARCHAR(10),
 fabricante VARCHAR(10),
 disponibilidade BIT(10),
 necessitaDeConserto BIT(10),
 quilometragem DOUBLE PRECISION,
 manutencaoNoDia BIT(10),
 filial VARCHAR(10),
 ano VARCHAR(10),
 ultimaRevisao DATE
);


CREATE TABLE Locacao (
 agenteDeLocacao VARCHAR(10),
 data DATE
);


CREATE TABLE Manutencao (
 data DATE
);


CREATE TABLE Motorista (
 CNH VARCHAR(10),
 Idade VARCHAR(10),
 apoliceSeguros VARCHAR(10),
 possuiContrato BIT(10),
 nome VARCHAR(10),
 dataLicenca DATE
);


CREATE TABLE Pagamento (
 tarifaDeRetorno DOUBLE PRECISION,
 tarifaDeDanificacao DOUBLE PRECISION,
 tarifaDeAtraso DOUBLE PRECISION,
 formaDePagamento VARCHAR(10),
 data DATE
);


