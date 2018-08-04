# LoggerFactory

Designed a logger factory which considers multiple levels of logging. Such as finer debug.
It uses filter design pattern for filtration criteria.

Also it uses Chain of responsibilty design pattern for multiple calls. 
Also handles thread synchronziation and multi threading async calls. 

Used Facade design pattern to hide the tedious logic.

And Always LoggerFactory should implement SingleTon design pattern. 
