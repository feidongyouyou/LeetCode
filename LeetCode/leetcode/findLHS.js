/**
 * Created by Administrator on 2017/5/21.
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var findLHS = function(nums) {
    var arr = [];

    var len = 0;
    var max = 0;
    for(var i = 0; i < nums.length; i++){
        for(var j = 1; j < nums.length; j++){
            if(Math.abs(nums[i] - nums[j]) <= 1){
                arr.push(nums[j]);
                len ++;
            }
        if(len > max){
            max = len;
        }

        }
    }
    return max;
};


Array.prototype.max = function(){
    return Math.max.apply({},this);
};

var numbers = [1,3,2,2,5,2,3,7];
var l = findLHS(numbers);
console.log(l);