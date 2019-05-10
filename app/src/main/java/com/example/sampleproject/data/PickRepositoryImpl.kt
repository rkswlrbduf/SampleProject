package com.example.sampleproject.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers

class PickRepositorylmpl {

    fun getContents(): Single<CuratingContents> {
        val gson = Gson()
        var preMessage : CuratingContents = gson.fromJson<CuratingContents>(" {\n" +
                "        \"id\": 234,\n" +
                "        \"title\": \"(기본문법) 쉽게 배워보는 조동사\",\n" +
                "        \"teacher_nickname\": \"수박하\",\n" +
                "        \"profile_image_key\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\",\n" +
                "        \"messages\": [\n" +
                "            {\n" +
                "                \"message\": \"쌤\",\n" +
                "                \"chat_type\": 2,\n" +
                "                \"image_url\": \"https:\\/\\/s3.ap-northeast-2.amazonaws.com\\/soolgitbucket01\\/ETC\\/image.jpg\",\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"요새 '조동사' 배우나요?!\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"넴 ㅜㅜ 쌤 어법이 너무 어려워여ㅠ\",\n" +
                "                \"chat_type\": 2,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"제가 아직 초등학생이라ㅠ\",\n" +
                "                \"chat_type\": 2,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"저 다섯 문장 중에서 조동사가 뭔지 한 번 찾아볼래요?\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"움 can이랑 will이요?\",\n" +
                "                \"chat_type\": 2,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"네 잘 찾았어요!ㅎㅎㅎ\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"'조'동사는 동사를 도와주는, 보조해주는 동사예요\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"문제에 나온 can - (동사)를 할 수 있다,\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"will - (동사)를 할 것이다 처럼\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"동사가 가진 기본 뜻에 다양한\\/특정한 의미를 더해줄 수 있는 게 조동사예요!\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"넹... ㅠ\",\n" +
                "                \"chat_type\": 2,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"그럼 조동사 다음에 동사가 더 나와야 문장 의미가 완성되겠죠?\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"그런데!\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"조동사 다음에 오는 동사는 '동사원형'만 올 수 있어요!\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"동사원형이요? 수업때 배우긴 했는데ㅠ\",\n" +
                "                \"chat_type\": 2,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"네ㅎㅎ 동사의 기본 형태? go, sing, dance 같이\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"아 보기에 워너원이 나와서ㅋㅋㅋㅋ워너원 노래중에 make me feel so high\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"여기에서 feel도 동사원형이에요.\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"앜ㅋㅋㅋㅋㅋㅋㅋ쌤ㅋㅋㅋ워너블이신가여\",\n" +
                "                \"chat_type\": 2,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"들켰당ㅎㅎㅎㅎㅎ 암튼 동사원형은 문법에서도 이곳저곳 많이 쓰이니 잘 알아두세여!ㅋㅋㅋ\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"보기 3번을 보면, BTS will dances with the music에서\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"will 다음에 dances가 왔는데, dances의 원형은 dance 죠!\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"그래서 정리하자면 답은 3번이구\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"3번이 잘못된 이유는 조동사(can, will) 다음에는 동사원형이 와야 하기 때문이에요 ㅎㅎ\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"앟ㅎㅎ 제가 뭔가 포인트를 잘 몰랐던 것 같네여ㅠ\",\n" +
                "                \"chat_type\": 2,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"아 근데 쌤 해석도 해주실 수 있나요ㅠ\",\n" +
                "                \"chat_type\": 2,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"음...잠시만 기다려주세여\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"초등학생이시라니까 자세히 써볼게여\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"여기\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": \"http:\\/\\/qanda-storage.s3.amazonaws.com\\/c3e895f0-01c8-43eb-93c5-0df20c3b4254.jpg\",\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"완전 엄밀하게 쓴 건 아닌데 ㅎㅎㅎ 그래도 이해를 도울 수 있게 써봤어요\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"우왕 ㅠ.ㅠ 감사합니다 쌤 ㅠㅠ\",\n" +
                "                \"chat_type\": 2,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"워너블이시라니 막 정도 가고ㅠ.ㅠ 감사해욤\",\n" +
                "                \"chat_type\": 2,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ친구도워너블이에요?ㅋㅋㅋㅋㅋ\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"저는 아미ㅎㅎㅎㅎ 그래도 뭔가 쌤도 아이돌 팬이시라구 하니까 ㅎㅎㅎ\",\n" +
                "                \"chat_type\": 2,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"ㅋㅋㅋㅋㅋ워너원과 함께 고3을 보냈어요ㅠㅠㅠ...특히대휘ㅠㅠㅠㅠㅠ...\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"bts 무대영상 보면 부모님은 안좋아하고ㅠ 공부 안하는 줄 알고ㅠ\",\n" +
                "                \"chat_type\": 2,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"쌤도 워너블이라니까 위안이 되네요ㅠ.ㅠ^!\",\n" +
                "                \"chat_type\": 2,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"ㅋㅋㅋㅋ위로가 많이 되었쬬... 수능 끝나고 워너원 콘서트 갔을떄ㅠㅠㅠㅠㅠㅠㅠㅠㄹㅇ감동이말할수없었어요ㅠㅠㅠㅠ\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"친구도 최애 보면서 위안두 얻고 앞으로 힘든 공부도 힘내길 바래요ㅠㅜ\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"그리구 아직 초등학생이시니까!!! 문법 어려워도 차근차근 하면 될거에요\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"녜 열심히 해볼게요 감사합니닿ㅎ.ㅎ!\",\n" +
                "                \"chat_type\": 2,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"아미친구도 응원할게요ㅜㅠ!!!ㅠㅠ...\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"ㅋㅋㅋㅋㅋㅋㅋㅋㅋ하성운이랑 지민도 절친이구(?)ㅋㅋㅋㅋㅋㅋ\",\n" +
                "                \"chat_type\": 1,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": \"https://s3.ap-northeast-2.amazonaws.com/soolgitbucket01/ETC/profile.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"message\": \"넹ㅋㅋㅋㅋㅋ\",\n" +
                "                \"chat_type\": 2,\n" +
                "                \"image_url\": null,\n" +
                "                \"user_nickname\": \"수박하\",\n" +
                "                \"profile_image\": null\n" +
                "            }\n" +
                "        ],\n" +
                "        \"created_at\": \"2019-04-17T08:31:12.605994Z\",\n" +
                "        \"like_count\": 106,\n" +
                "        \"comment_count\": 20,\n" +
                "        \"is_liked\": 0,\n" +
                "        \"thumbnail\": \"https:\\/\\/qanda-server-storage.s3.amazonaws.com\\/uploads\\/curation\\/cotents\\/english-2724442_1920_f13d48f6028d40f890e3f552da77c89d.jpg\",\n" +
                "        \"tag\": 1,\n" +
                "        \"view_count\": 4362,\n" +
                "        \"is_bookmark\": 0\n" +
                "    }", CuratingContents::class.java)
        return Single.just(preMessage).subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getRelatedContents(): Single<ArrayList<CuratingContents>> {
        val gson = Gson()
        var preMessage : ArrayList<CuratingContents> = gson.fromJson("\n" +
                "[\n" +
                "{\n" +
                "\"id\":233,\n" +
                "\"title\":\"올해 첫 시험, 공부 계획!\",\n" +
                "\"teacher_nickname\":\"얼죽아\",\n" +
                "\"profile_image_key\":null,\n" +
                "\"created_at\":\"2019-04-09T11:40:18.027816Z\",\n" +
                "\"like_count\":338,\n" +
                "\"comment_count\":184,\n" +
                "\"tag\":1,\n" +
                "\"is_liked\":0,\n" +
                "\"thumbnail\":\"https://qanda-server-storage.s3.amazonaws.com/uploads/curation/cotents/time-3222267_640_e5a287d557054d598dc43878a97c4f76.jpg\",\n" +
                "\"view_count\":9988\n" +
                "},\n" +
                "{\n" +
                "\"id\":231,\n" +
                "\"title\":\"수학 실력이 안늘어요ㅠㅠ\",\n" +
                "\"teacher_nickname\":\"김선일\",\n" +
                "\"profile_image_key\":\"4297a793-e2f3-4397-8a1c-cb7bc1897fe0\",\n" +
                "\"created_at\":\"2019-03-25T11:52:59.956808Z\",\n" +
                "\"like_count\":538,\n" +
                "\"comment_count\":442,\n" +
                "\"tag\":1,\n" +
                "\"is_liked\":0,\n" +
                "\"thumbnail\":\"https://qanda-server-storage.s3.amazonaws.com/uploads/curation/cotents/business-1868015_1920_31d2a9734eb4495e99ebe27bb77295cd.jpg\",\n" +
                "\"view_count\":24523\n" +
                "},\n" +
                "{\n" +
                "\"id\":230,\n" +
                "\"title\":\"중학교 입학 첫 달\",\n" +
                "\"teacher_nickname\":\"연대쌤\",\n" +
                "\"profile_image_key\":\"74f3086d-97b0-4a7b-aa6e-1bfc55004b5e\",\n" +
                "\"created_at\":\"2019-03-25T11:29:59.594889Z\",\n" +
                "\"like_count\":227,\n" +
                "\"comment_count\":183,\n" +
                "\"tag\":1,\n" +
                "\"is_liked\":0,\n" +
                "\"thumbnail\":\"https://qanda-server-storage.s3.amazonaws.com/uploads/curation/cotents/upset-534103_1920_2b964c3a0fe94fcda16bc94ba92c922d.jpg\",\n" +
                "\"view_count\":11913\n" +
                "},\n" +
                "{\n" +
                "\"id\":229,\n" +
                "\"title\":\"첫 모의고사.. 영어 시간 단축ㅠㅠ\",\n" +
                "\"teacher_nickname\":\"콴다킹\",\n" +
                "\"profile_image_key\":\"3341be3d-73ce-4236-bf3f-c4cc9cf930de\",\n" +
                "\"created_at\":\"2019-03-14T09:46:43.983536Z\",\n" +
                "\"like_count\":167,\n" +
                "\"comment_count\":110,\n" +
                "\"tag\":1,\n" +
                "\"is_liked\":0,\n" +
                "\"thumbnail\":\"https://qanda-server-storage.s3.amazonaws.com/uploads/curation/cotents/homework-2521144_1920_dd39c40f03594ede9a40898ccfdabd51.jpg\",\n" +
                "\"view_count\":12162\n" +
                "}\n" +
                "]", object: TypeToken<ArrayList<CuratingContents>>(){}.type)
        return Single.just(preMessage).subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
    }

}