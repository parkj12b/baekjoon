function solution(emergency) {
  var arr = [];
  var answer = [];
  
  for(let i = 1; i <= emergency.length; i++){
      arr[i-1] = {priority: emergency[i-1], index: i};
  }
  
  arr.sort((a, b)=>{
    return b.priority - a.priority;
  });

  for(let i = 0; i < arr.length; i++){
    let index = arr[i].index;
    answer[index-1] = i+1;
  }

    
    
  return answer;
}