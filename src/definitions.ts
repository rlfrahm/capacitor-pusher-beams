declare global {
  interface PluginRegistry {
    PusherBeams?: PusherBeamsPlugin;
  }
}

export interface PusherBeamsPlugin {
  echo(options: { value: string }): Promise<{value: string}>;
  start(): Promise<{}>
  addDeviceInterest(options: { interest: string}): Promise<{success: boolean}>;
  removeDeviceInterest(options: { interest: string }): Promise<{ success: boolean }>;
  getDeviceInterests(options: {interests: Array<String>}): Promise<{interests: Array<String>}>;
  setDeviceInterests(): Promise<{success: boolean}>;
  clearDeviceInterests(): Promise<{success: boolean}>;
  setOnDeviceInterestsChangedListener(): Promise<{success: boolean}>;
  setOnMessageReceivedListenerForVisibleActivity(): Promise<{success: boolean}>;
  setUserID(options: { beamsAuthURL: string, userID: string }): Promise<{ success: boolean, message: string }>;
  clearAllState(): Promise<{success: boolean}>;
  stop(): Promise<{success: boolean}>;
}