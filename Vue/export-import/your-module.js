import {hello, student as s, pi} from './my-module.js'; //상대경로. 이폴더에서 저 .js를 가져다 쓰겠다고함 //별칭도 사용
import {singer} from './my-module.js';
import member from './my-module.js'; //{}없이 바로 디폴트를 별칭을 주며 받아옴

import dongju from './his-module.js';

console.log(hello('vue'));
console.log(s.name, s.address, s.age); 
console.log(pi);

console.log(singer);

console.log(member.id);
console.log(member.pw);
console.log(member.num);

console.log(dongju.number);
console.log(dongju.color);
console.log(dongju.name);
