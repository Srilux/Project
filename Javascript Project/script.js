const clock=document.querySelector(`.clock`);

function runClock(){
    var time= new Date();
    var hrs=time.getHours();
    var min=time.getMinutes();
    var sec=time.getSeconds();
    var txt="AM";
  
    if(hrs>12){
        hrs=hrs-12;
        txt="PM"
    }else if(hrs==0){
        hrs=12;
        txt="AM";
    }
    hrs=hrs<10?'0'+hrs:hrs;
    min=min<10?'0'+min:min;
    sec=sec<10?'0'+sec:sec;

    clock.innerHTML=`${hrs} : ${min} : ${sec} ${txt}`;
}
runClock();
setInterval(runClock,1000);
  
const month=["January","February","March","April","May","June","July","August","September","October","November","December"];
const d=new Date();
let name1=month[d.getMonth()];
document.getElementById("demo").innerHTML = name1;

const N=new Date();
let date=N.getDate();
document.getElementById("demo1").innerHTML = date;

const week=["Sun","Mon","Tues","Wed","Thurs","Fri","Sat"];
const W=new Date();
let day=week[W.getDay()];
document.getElementById("demo2").innerHTML = day;


