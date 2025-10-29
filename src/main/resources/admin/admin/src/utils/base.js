const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot1eev7z37/",
            name: "springboot1eev7z37",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot1eev7z37/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于springboot的马术俱乐部管理系统设计与实现"
        } 
    }
}
export default base
