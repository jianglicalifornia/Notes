SQL
=================

declare @i int 
set @i=1 
while @i<30 
begin 
	insert into test (userid) values(@i) 
	set @i=@i+1 
end


declare @FromDate date = '2011-01-01'
declare @ToDate date = '2011-12-31'

select dateadd(day, 
               rand(checksum(newid()))*(1+datediff(day, @FromDate, @ToDate)), 
               @FromDate)