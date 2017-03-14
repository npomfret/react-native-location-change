
#import "RNLocationChange.h"

@implementation RNLocationChange

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

- (NSArray<NSString *> *)supportedEvents {
    return @[@"locationChanged"];
}

RCT_EXPORT_METHOD(start) {
    NSDictionary *dictionary = @{
                                 @"foo": @"bar",
                                 };
    [self sendEventWithName:@"locationChanged" body:dictionary];
}

@end
