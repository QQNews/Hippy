/* Tencent is pleased to support the open source community by making Hippy available.
 * Copyright (C) 2018 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tencent.mtt.hippy.adapter.monitor;

import com.tencent.mtt.hippy.HippyRootView;

import java.util.List;

/**
 * FileName: HippyEngineMonitorAdapter
 * Description：
 * History：
 * 1.0 xiandongluo on 2018/1/23
 */
public interface HippyEngineMonitorAdapter
{

  String TAG = "HippyEngineMonitorAdapter";
	int	ENGINE_LOAD_RESULT_SUCCESS	= 0;
	int	ENGINE_LOAD_RESULT_ERROR	= 1;
	int	ENGINE_LOAD_RESULE_TIMEOUT	= 2;

	void reportEngineLoadStart();

	void reportEngineLoadResult(int code, int loadTime, List<HippyEngineMonitorEvent> loadEvents, Throwable e);

	void reportModuleLoadComplete(HippyRootView rootView, int loadTime, List<HippyEngineMonitorEvent> loadEvents);

	boolean needReportBridgeANR();

	void reportBridgeANR(String message);

  /**
   * 以下接口是为了排查init engine timeout临时引入
   * <p>
   * initEngine分两个流程：initJsBridge & 加载common js，排查看看卡在了哪个流程先
   */
  void startInitEngine();

  void endInitJsBridge();

  void endLoadCommonJs();

  void endInitEngine();
}
