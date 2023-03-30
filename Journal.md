- [ ] Pandas Fundamentals
- [x] NumPy Fundamentals
- [ ] Matplotlib Fundamentals


# KT Counterparts 
The most important library is Kotlin DataFrame, a successor
of Krangl. It's developed considering the previous functionalities offered by
krangl, and integrating them with a lot of similarities with pandas. On the
other hand, it has all the benefits that a strong typing language has, adding
also kotlin null values handling.

# Bried sparse notes
## (29/03)
I've discovered how it's easy to work with ND arrays in Multik, the interface
`ND`
- It's being used for more that 4 dimensional matrices
- It's being used for unknown matrices sizes

It's also possibile to generate random matrices with any number of dimensions,
and the size is computed accordingly. Also reshape is working pretty darn
good providing a `IntArray` of dimensions or the `varaarg` is available.

From the other hand, pure vectores are very useful for computation things, but
not for categorizing data. We need to make tests on how multi dimensional
arrays in dataframe are treated.

## DataFrame

Core Features:
- **Hierarchical**: represents hierarchical data structures, such as JSON or a
  tree of JVM Objects.
- **Functional**: Data processing pipeline is organized in a chain of
  `DataFrame` transformation operations. Every operation returns a new instance
  of `DataFrame` reusing underlying storage whenever it's possible.
- **Readable**: data transformation operations are defined in DSL close to
  natural language.
- **Practical**: provides simple solutions for common problems and ability to
  perform complex tasks.
- **Interoperable**: convertable with kotlin data classes and collections
- **Generic**: can store objects of any type (not only numbers or strings).
- **TypeSafe**: on the fly generation of extension properties for type safe
  data access with kotlin-style care for null safety.
- **Polymorphic**: type compatibility derives from column schema compatibility.
  You can define a function that requires a special subset of columns in
  dataframe, but does not care about other columns.

### Notes 
Under the hood uses a lot of multik datastructures,like NDArrays or
hierarchical indexes. It's possible to underline a lot of differences between
Pandas, and a strict comparison can be made if only it's divided by chapters
like the book about Data Science with python does.


## Multik
Multik is composed by the modules:
- `api`: Here is contained the `mk` object, the one that stores all sorts of
  methods for creating and computing math along arrays (e.g. `mk.arange,
  mk.ones, mk.math.dot`, called "aggregation functions"), just like `np` in
  Python when using the whole package alias.
- `api.io`: I/O functionalities, not so much used for DS
- `api.linalg`: Linear algebra package (accessible also via `mk.linalg`), it
  contains some basic linear algebra operations, like eigenvalues and
  eigenvectors calculation, `solve()` for solving linear matrix equation,
  `qr()` QR decomposition, ...
- `api.math`: Some basic mathematical operations, like min/max, cumSum, exp log
  sin and cos functions.
- `api.stat`: Contains interfaces for means, average, median and abs, this is
  the place where a more mathematical library can be combined with multik, if
  needed.
- `ndarray.complex`: Package that contains all the methods that can be called
  on complex `MultiArrays`; it condensate also all the other packages, like
  math or operations.
- `ndarray.data`: Contains all the data references, like how the data is stored
  inside the MultiArrray (`MemoryView`), all the arrays declination and
  `Dimensions` definitions.
- `ndarray.operations`: it can be viewed as an adapter to kotlin collections'
  methods, meaning that it contains all the methods like `reduce`, `map`,
  `flatMap`, `filter`, `associateBy`, `forEach`, and so on, each one of them
  with the corresponding declination if it is a single dimension array
  (`D1Array`) or a multi dimensional array (D > 1 up to N).

It's very powerful, pretty optimized along various platforms (even apple
silicon macs!).

It's also available a small "Context-Oriented" approach for math calculation with
matrices; I think that this functionality is echoed with KMath and their kernels
to make multidimensional vectorized spaces.

As today (30/03/23), no broadcasting turnaround were found, as always, need
to check if it's a vital feature.

### Notes
Testing broadcasting Implementation, need to understand which are all the
cases, and mainly the **NEEDS**. A simple Implementation of the sum can be
found in kotlin projects folder.

A few notes in case that thing has to go on
- That Implementation can be more generic using the clause function for each
  operation that can be made (+, -, /, %, *, ...).
- Try to find a way to generalize up to 2D broadcasting (the transpose trick
  could not work)

## Kmath
I've divscovered [https://github.com/SciProgCentre/kmath](Kmath), a numerical
library for math, largely inspired by python NumPy.

A nice article about how Kmath interacts with context, and what is the trend of
kotlin's context-oriented programming
[https://aip.scitation.org/doi/pdf/10.1063/1.5130103](Article) talking about
Kmath and how context-oriented programming helps it's core.

It's very complicated, need to scrape a bit because it contains TONS of
mathematical functions and complex things, and event it's functionalities are
pretty hard to handle because of Context things.

BUT: there's a Multik like wrapper, if the things go further in the need of
more complex operations, deep dive into kmath/multik (currently under
developement)


It's possibile to try to make some differences between Kmath and
Apche Commons Math (`org.apache.commons.math3`). I saw a multivariate 
gaussinan distribution.

---

# Kotlin
[https://proandroiddev.com/an-introduction-context-oriented-programming-in-kotlin-2e79d316b0a2](Link).

Discoveries context-oriented programming benefits. Largely used in DSL code
declaration and in type safe builders. The syntax seems to be kind of tricky
to get at first, but benefits are a lot!

A decent knowledge about extension functions is required, and also how
lambdas and function literals works (lambdas section of kotlin's guide).

--- 
## Chapters

### Array and Vectorized 
Here comes in the game Multik, a kotlin library for
representing NDArrays (Array of N dimensions). This library is very similar
with Python NumPy, with all the advantages listed above about using kotlin vs.
Python.

### Data Loading, Storage and Files

### Data Cleaning and Preparation
Kotlin dataframe has nothing to envy to
Pandas, data prepping is pretty straightforward. It's possible to filter nulls,
fill nulls, convert read data into various datatype with explicit casting, or
there are simple built in casting to Int, Double, String
LocalDateTime/LocalDate, and I think that's it.



### Data Wrangling: Join, Combine and Reshaping DataFrames

### Plotting and Visualization: Matplotlib and GGplot differences
Lets-Plot is a kotlin API for the  Lets-Plot library, an open source library 
for statistical data largely based on **ggplot** APIs. 
It's built on the principles of layered graphics 

It's pretty easy to use kotlin DataFrame for visualizing statistical data with
Lets-Plot, because every Object inside DataFrame (DataColumn, ColumnGroup, ...)
can be converted instantly to a Map, accepted by every kind of plot of GGPlot.

Lots of types of charts, it's possible to customize everything and every 
aspect of the library is provided with a well documented API reference and 
tons of examples on jupyter (links in the API reference in most of the 
packages i.e. `stats`, `geom`, ...).

### Data Aggregation and Grouping strategies


