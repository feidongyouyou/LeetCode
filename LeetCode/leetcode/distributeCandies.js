/**
 * Created by Administrator on 2017/5/7.
 */
var distributeCandies = function(candies) {
    var len = candies.length;
    var sisterCandies = [candies[0]];
    // sisterCandies.length = len/2;
    // sisterCandies.push(candies[0]);
    // console.log(sisterCandies);
    var i;
    var count = 1;
    for(i = 1; i < len; i++){
        if(sisterCandies.length <= (len/2)-1) {
            if (sisterCandies.indexOf(candies[i]) == -1) {
                sisterCandies.push(candies[i]);
                console.log(sisterCandies);
                count++;
            }
        }
    }
    // console.log("****"+sisterCandies);
    return count;
};
var candy = [1,1,2,3];
var m = distributeCandies(candy);
console.log("&&&&&"+m);